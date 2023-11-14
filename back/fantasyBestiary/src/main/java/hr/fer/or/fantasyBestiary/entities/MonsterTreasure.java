package hr.fer.or.fantasyBestiary.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "monster_treasure")
public class MonsterTreasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monster_treasure_id")
    private Long monsterTreasureId;

    @ManyToOne
    @JoinColumn(name = "monster_id", referencedColumnName = "monster_id")
    private Monster monster;

    @ManyToOne
    @JoinColumn(name = "treasure_type_id", referencedColumnName = "treasure_type_id")
    private TreasureType treasureType;

    public MonsterTreasure() {
    }

    public MonsterTreasure(Long monsterTreasureId, Monster monster, TreasureType treasureType) {
        this.monsterTreasureId = monsterTreasureId;
        this.monster = monster;
        this.treasureType = treasureType;
    }

	public Long getMonsterTreasureId() {
		return monsterTreasureId;
	}

	public void setMonsterTreasureId(Long monsterTreasureId) {
		this.monsterTreasureId = monsterTreasureId;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public TreasureType getTreasureType() {
		return treasureType;
	}

	public void setTreasureType(TreasureType treasureType) {
		this.treasureType = treasureType;
	}
	
}
