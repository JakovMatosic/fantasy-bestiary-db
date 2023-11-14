export class Monster {
  constructor(
    public monsterId: number,
    public name: string,
    public frequency: string,
    public activityCycle: string,
    public numberAppearing: number,
    public alignment: string,
    public armorClass: number,
    public movement: string,
    public hitDice: string,
    public thaco: number,
    public attack: string,
    public size: string,
    public morale: string,
    public experience: number
  ) {}
}
