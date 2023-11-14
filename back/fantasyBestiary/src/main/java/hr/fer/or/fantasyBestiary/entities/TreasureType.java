package hr.fer.or.fantasyBestiary.entities;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "treasure_type")
public class TreasureType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "treasure_type_id")
	private Long treasureTypeId;

	@Column(name = "treasure_type_name", nullable = false)
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
	
//	@ManyToMany(mappedBy = "treasureTypes", fetch = FetchType.LAZY)
//    private Set<Monster> monsters;

	public TreasureType() {
	}

	public TreasureType(String treasureTypeName, String copperRange, String silverRange, String goldRange,
			String electrumRange, String gemsRange, String artObjectsRange, String item, Integer percentageCopper,
			Integer percentageSilver, Integer percentageGold, Integer percentageElectrum, Integer percentageGems,
			Integer percentageArtObjects, Integer percentageItem) {
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

	public Long getTreasureTypeId() {
		return treasureTypeId;
	}

	public void setTreasureTypeId(Long treasureTypeId) {
		this.treasureTypeId = treasureTypeId;
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

//	public Set<Monster> getMonsters() {
//		return monsters;
//	}
//
//	public void setMonsters(Set<Monster> monsters) {
//		this.monsters = monsters;
//	}

}
