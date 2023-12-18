package hr.fer.or.fantasyBestiary.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "monster")
public class Monster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "monster_id")
	private Long monsterId;

	@Column(name = "name", nullable = false)
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

	public Monster() {
	}

	public Monster(String name, String frequency, String activityCycle, String numberAppearing, String alignment,
			Integer armorClass, String movement, String hitDice, Integer thaco, String attack, String size,
			String morale, Integer experience) {
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
	}

	public Long getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(Long monsterId) {
		this.monsterId = monsterId;
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
	
}
