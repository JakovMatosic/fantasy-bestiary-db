import { Component, Inject } from '@angular/core';
import { TreasureType } from '../../models/treasure.type';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-treasure',
  templateUrl: './dialog-treasure.component.html',
  styleUrl: './dialog-treasure.component.css'
})
export class DialogTreasureComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: { treasureType: TreasureType }) {}
}
