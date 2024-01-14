export class TreasureType {
  constructor(
    public treasureTypeId: number,
    public treasureTypeName: string,
    public copperRange: string,
    public silverRange: string,
    public goldRange: string,
    public electrumRange: string,
    public gemsRange: string,
    public artObjectsRange: string,
    public itemDescription: string,
    public percentageCopper: number,
    public percentageSilver: number,
    public percentageGold: number,
    public percentageElectrum: number,
    public percentageGems: number,
    public percentageArtObjects: number,
    public percentageItem: number
  ) {}
}
