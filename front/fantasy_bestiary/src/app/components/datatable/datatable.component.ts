import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Monster } from '../../models/monster';
import { TreasureType } from '../../models/treasure.type';
import { DataService } from '../../service/data.service';
import { forkJoin, map } from 'rxjs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule, NgForm } from '@angular/forms';
import { DialogTreasureComponent } from '../dialog-treasure/dialog-treasure.component';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';
import { ApiResponse } from '../../models/api.response';

@Component({
  selector: 'app-datatable',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
  ],
  templateUrl: './datatable.component.html',
  styleUrl: './datatable.component.css',
})
export class DatatableComponent {
  displayedColumns: string[] = [
    'monsterId',
    'name',
    'frequency',
    'activityCycle',
    'numberAppearing',
    'alignment',
    'armorClass',
    'movement',
    'hitDice',
    'thaco',
    'attack',
    'size',
    'morale',
    'experience',
    'treasure_types',
  ];

  dataSource: MatTableDataSource<MonsterTreasure> =
    new MatTableDataSource<MonsterTreasure>();
  monsterTreasureArr: MonsterTreasure[] = [];
  selectedColumn: string = 'All'; // Default to 'All'

  constructor(private dataService: DataService, public dialog: MatDialog) {}

  ngOnInit() {
    this.dataService.getAllMonsters().subscribe((monsterResponse: any) => {
      let monsters = monsterResponse.data;
      const monsterObservables = monsters.map((monster: Monster) => {
        return this.dataService.getTreasuresForMonster(monster.monsterId).pipe(
          map((monsterTreasureResponse: any) => {
            let treasures = monsterTreasureResponse.data;
            return {
              monster: monster, // Assuming 'monster' is a variable in the surrounding scope
              treasures: treasures,
            };
          })
        );
      });

      forkJoin(monsterObservables).subscribe(
        (monsterTreasures: MonsterTreasure[] | unknown) => {
          if (Array.isArray(monsterTreasures)) {
            this.dataSource.data = monsterTreasures;
            this.monsterTreasureArr = monsterTreasures;
          } else {
            console.error('Unexpected response format:', monsterTreasures);
          }
        }
      );
    });
  }

  downloadJsonFile() {
    const data = JSON.stringify(this.dataSource.data, null, 2);
    const blob = new Blob([data], { type: 'application/json' });

    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'data.json';

    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  }

  downloadCsvFile() {
    // Hardcoded
    const headers =
      'Monster ID,Name,Frequency,Activity Cycle,Number Appearing,Alignment,Armor Class,Movement,Hit Dice,Thaco,Attack,Size,Morale,Experience,' +
      'Treasure Type ID,Treasure Type Name,Copper Range,Silver Range,Gold Range,Electrum Range,Gems Range,Art Objects Range,Item Description,' +
      'Percentage Copper,Percentage Silver,Percentage Gold,Percentage Electrum,Percentage Gems,Percentage Art Objects,Percentage Item';

    const csvContent = this.dataSource.data
      .map((obj) => {
        const monster = obj.monster;
        const treasures = obj.treasures
          .map((treasure) => {
            return Object.values(treasure)
              .map((value) => this.escapeCsvValue(value))
              .join(',');
          })
          .join('\n');

        return (
          Object.values(monster)
            .map((value) => this.escapeCsvValue(value))
            .join(',') +
          ',' +
          treasures
        );
      })
      .join('\n');

    const blob = new Blob([headers + '\n' + csvContent], { type: 'text/csv' });

    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'data.csv';

    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  }

  // Function to escape CSV values
  escapeCsvValue(value: any): string {
    if (typeof value === 'string' && value.includes(',')) {
      return `"${value}"`;
    }
    return value;
  }

  showTreasure(treasureType: TreasureType) {
    const dialogRef = this.dialog.open(DialogTreasureComponent, {
      height: '20rem',
      width: '35rem',
      data: { treasureType: treasureType },
    });
  }

  filterData(form: NgForm) {
    if (this.selectedColumn === 'All') {
      this.filterAll(form);
    } else {
      this.filterColumn(form);
    }
  }

  filterColumn(form: NgForm) {
    const filter = form.value.filterValue.trim().toLowerCase();

    const filteredData = this.monsterTreasureArr.filter(
      (monsterTreasure: MonsterTreasure) => {
        const monster = monsterTreasure.monster as { [key: string]: any };
        const treasures = monsterTreasure.treasures;

        if (this.selectedColumn === 'treasure_types') {
          for (const treasure of treasures) {
            const treasureTypeName = treasure.treasureTypeName.toLowerCase();
            if (treasureTypeName.includes(filter)) {
              return true;
            }
          }
        } else {
          //we know it is not All
          const key = this.selectedColumn;
          if (monster.hasOwnProperty(key)) {
            const attributeValue = String(monster[key]).toLowerCase();
            if (attributeValue.includes(filter)) {
              return true;
            }
          }
        }

        return false; //  no match = no monster
      }
    );
    this.dataSource.data = filteredData;
  }

  filterAll(form: NgForm) {
    //filters
    const filter = form.value.filterValue.trim().toLowerCase();

    const filteredData = this.monsterTreasureArr.filter(
      (monsterTreasure: MonsterTreasure) => {
        const monster = monsterTreasure.monster as { [key: string]: any };
        const treasures = monsterTreasure.treasures;

        for (const key in monster) {
          if (monster.hasOwnProperty(key)) {
            const attributeValue = String(monster[key]).toLowerCase();
            if (attributeValue.includes(filter)) {
              return true;
            }
          }
        }

        for (const treasure of treasures) {
          const treasureTypeName = treasure.treasureTypeName.toLowerCase();
          if (treasureTypeName.includes(filter)) {
            return true;
          }
        }

        return false; //  no match = no monster
      }
    );
    this.dataSource.data = filteredData;
  }
}

interface MonsterTreasure {
  monster: Monster;
  treasures: TreasureType[];
}
