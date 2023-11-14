import { Component, Inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TreasureType } from '../../models/treasure.type';

@Component({
  selector: 'app-dialog-treasure',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dialog-treasure.component.html',
  styleUrl: './dialog-treasure.component.css',
})
export class DialogTreasureComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: { treasureType: TreasureType }) {}
}
