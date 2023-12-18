package hr.fer.or.fantasyBestiary.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FullEntry {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monster_treasure_id")
    private Long monsterTreasureId;

    @Column(name = "name")
	private String name;

	@Column(name = "frequency")
	private String frequency;

	@Column(name = "activity_cycle")
	private String activityCycle;

	@Column(name = "number_appearing")
	private String numberAppearing;

	@Column(name = "alignment")
	private String alignment;

	@Column(name = "armor_class")
	private Integer armorClass;

	@Column(name = "movement")
	private String movement;

	@Column(name = "hit_dice")
	private String hitDice;

	@Column(name = "thaco")
	private Integer thaco;

	@Column(name = "attack")
	private String attack;

	@Column(name = "size")
	private String size;

	@Column(name = "morale")
	private String morale;

	@Column(name = "experience")
	private Integer experience;
	
	@Column(name = "treasure_type_name")
	private String treasureTypeName;

	@Column(name = "copper_range")
	private String copperRange;

	@Column(name = "silver_range")
	private String silverRange;

	@Column(name = "gold_range")
	private String goldRange;

	@Column(name = "electrum_range")
	private String electrumRange;

	@Column(name = "gems_range")
	private String gemsRange;

	@Column(name = "art_objects_range")
	private String artObjectsRange;

	@Column(name = "item")
	private String item;

	@Column(name = "percentage_copper")
	private Integer percentageCopper;

	@Column(name = "percentage_silver")
	private Integer percentageSilver;

	@Column(name = "percentage_gold")
	private Integer percentageGold;

	@Column(name = "percentage_electrum")
	private Integer percentageElectrum;

	@Column(name = "percentage_gems")
	private Integer percentageGems;

	@Column(name = "percentage_art_objects")
	private Integer percentageArtObjects;

	@Column(name = "percentage_item")
	private Integer percentageItem;

	public FullEntry(String name, String frequency,
			String activityCycle, String numberAppearing, String alignment, Integer armorClass, String movement,
			String hitDice, Integer thaco, String attack, String size, String morale, Integer experience,
			String treasureTypeName, String copperRange, String silverRange, String goldRange, String electrumRange,
			String gemsRange, String artObjectsRange, String item, Integer percentageCopper, Integer percentageSilver,
			Integer percentageGold, Integer percentageElectrum, Integer percentageGems, Integer percentageArtObjects,
			Integer percentageItem) {
		this.name = name;
		this.frequency = frequency;
		this.activityCycle = activityCycle;
		this.numberAppearing = numberAppearing;
		this.alignment = alignment;
		this.armorClass = armorClass;
		this.movement = movement;
		this.hitDice = hitDice;
		this.thaco = thaco;
		this.attack = attack;
		this.size = size;
		this.morale = morale;
		this.experience = experience;
		this.treasureTypeName = treasureTypeName;
		this.copperRange = copperRange;
		this.silverRange = silverRange;
		this.goldRange = goldRange;
		this.electrumRange = electrumRange;
		this.gemsRange = gemsRange;
		this.artObjectsRange = artObjectsRange;
		this.item = item;
		this.percentageCopper = percentageCopper;
		this.percentageSilver = percentageSilver;
		this.percentageGold = percentageGold;
		this.percentageElectrum = percentageElectrum;
		this.percentageGems = percentageGems;
		this.percentageArtObjects = percentageArtObjects;
		this.percentageItem = percentageItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getActivityCycle() {
		return activityCycle;
	}

	public void setActivityCycle(String activityCycle) {
		this.activityCycle = activityCycle;
	}

	public String getNumberAppearing() {
		return numberAppearing;
	}

	public void setNumberAppearing(String numberAppearing) {
		this.numberAppearing = numberAppearing;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public Integer getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(Integer armorClass) {
		this.armorClass = armorClass;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	public String getHitDice() {
		return hitDice;
	}

	public void setHitDice(String hitDice) {
		this.hitDice = hitDice;
	}

	public Integer getThaco() {
		return thaco;
	}

	public void setThaco(Integer thaco) {
		this.thaco = thaco;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMorale() {
		return morale;
	}

	public void setMorale(String morale) {
		this.morale = morale;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getTreasureTypeName() {
		return treasureTypeName;
	}

	public void setTreasureTypeName(String treasureTypeName) {
		this.treasureTypeName = treasureTypeName;
	}

	public String getCopperRange() {
		return copperRange;
	}

	public void setCopperRange(String copperRange) {
		this.copperRange = copperRange;
	}

	public String getSilverRange() {
		return silverRange;
	}

	public void setSilverRange(String silverRange) {
		this.silverRange = silverRange;
	}

	public String getGoldRange() {
		return goldRange;
	}

	public void setGoldRange(String goldRange) {
		this.goldRange = goldRange;
	}

	public String getElectrumRange() {
		return electrumRange;
	}

	public void setElectrumRange(String electrumRange) {
		this.electrumRange = electrumRange;
	}

	public String getGemsRange() {
		return gemsRange;
	}

	public void setGemsRange(String gemsRange) {
		this.gemsRange = gemsRange;
	}

	public String getArtObjectsRange() {
		return artObjectsRange;
	}

	public void setArtObjectsRange(String artObjectsRange) {
		this.artObjectsRange = artObjectsRange;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getPercentageCopper() {
		return percentageCopper;
	}

	public void setPercentageCopper(Integer percentageCopper) {
		this.percentageCopper = percentageCopper;
	}

	public Integer getPercentageSilver() {
		return percentageSilver;
	}

	public void setPercentageSilver(Integer percentageSilver) {
		this.percentageSilver = percentageSilver;
	}

	public Integer getPercentageGold() {
		return percentageGold;
	}

	public void setPercentageGold(Integer percentageGold) {
		this.percentageGold = percentageGold;
	}

	public Integer getPercentageElectrum() {
		return percentageElectrum;
	}

	public void setPercentageElectrum(Integer percentageElectrum) {
		this.percentageElectrum = percentageElectrum;
	}

	public Integer getPercentageGems() {
		return percentageGems;
	}

	public void setPercentageGems(Integer percentageGems) {
		this.percentageGems = percentageGems;
	}

	public Integer getPercentageArtObjects() {
		return percentageArtObjects;
	}

	public void setPercentageArtObjects(Integer percentageArtObjects) {
		this.percentageArtObjects = percentageArtObjects;
	}

	public Integer getPercentageItem() {
		return percentageItem;
	}

	public void setPercentageItem(Integer percentageItem) {
		this.percentageItem = percentageItem;
	}
}
