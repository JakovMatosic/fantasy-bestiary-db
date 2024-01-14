import { NgIfContext } from '@angular/common';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { DataService } from '../../service/data.service';
import { Monster } from '../../models/monster';
import { forkJoin, map } from 'rxjs';
import { TreasureType } from '../../models/treasure.type';
import { Router } from '@angular/router';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrl: './info.component.css',
})
export class InfoComponent implements OnInit {
  
  monsterTreasureArr: any[] = [];
  otherButton: boolean = false;
  public loggedInUser: any;

  constructor(public auth: AuthService, private dataService: DataService, public router: Router) {}
  ngOnInit(): void {
    if(this.auth.isAuthenticated$) {
      this.refreshDownloads();
    }
  }

  refreshDownloads() {
    this.otherButton = true;
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
            this.monsterTreasureArr = monsterTreasures;
          } else {
            console.error('Unexpected response format:', monsterTreasures);
          }
        }
      );
    });
  }
  
  downloadJsonFile() {
    const data = JSON.stringify(this.monsterTreasureArr, null, 2);
    const blob = new Blob([data], { type: 'application/json' });

    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'fantasy_bestiary.json';

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

    const csvContent = this.monsterTreasureArr
      .map((obj: MonsterTreasure) => {
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
    link.download = 'fantasy_bestiary.csv';

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
}

interface MonsterTreasure {
  monster: Monster;
  treasures: TreasureType[];
}
