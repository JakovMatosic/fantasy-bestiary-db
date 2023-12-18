package hr.fer.or.fantasyBestiary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.or.fantasyBestiary.entities.FullEntry;
import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.repository.MonsterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

	private final MonsterRepository monsterRepository;
	private final TreasureTypeService treasureTypeService;

	@Autowired
	public MonsterService(MonsterRepository monsterRepository, TreasureTypeService treasureTypeService) {
		this.monsterRepository = monsterRepository;
		this.treasureTypeService = treasureTypeService;
	}

	public Optional<Monster> getMonsterById(Long id) {
		return monsterRepository.findById(id);
	}

	public List<Monster> getAllMonsters() {
		return monsterRepository.findAll();
	}

	public List<TreasureType> findTreasuresByMonsterId(Long monsterId) {
		return monsterRepository.findTreasuresByMonsterId(monsterId);
	}

	public List<FullEntry> getAllEntries() {
		// return monsterRepository.getAllEntries();
		List<Monster> monsters = this.getAllMonsters();
		List<TreasureType> treasureTypes = treasureTypeService.getAllTreasureTypes();

		List<FullEntry> entryList = new ArrayList<FullEntry>();
		List<Long> addedTreasureIds = new ArrayList<Long>();
		for (Monster monster : monsters) {
			List<TreasureType> monsterTreasures = findTreasuresByMonsterId(monster.getMonsterId());
			if (monsterTreasures == null || monsterTreasures.isEmpty()) {
				FullEntry entryToAdd = new FullEntry(monster.getName(), monster.getFrequency(),
						monster.getActivityCycle(), monster.getNumberAppearing(), monster.getAlignment(),
						monster.getArmorClass(), monster.getMovement(), monster.getHitDice(), monster.getThaco(),
						monster.getAttack(), monster.getSize(), monster.getMorale(), monster.getExperience(),
						// TreasureType-related fields are null because no treasure type
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				entryList.add(entryToAdd);
			} else {
				for (TreasureType tt : monsterTreasures) {
					FullEntry entryToAdd = new FullEntry(monster.getName(), monster.getFrequency(),
							monster.getActivityCycle(), monster.getNumberAppearing(), monster.getAlignment(),
							monster.getArmorClass(), monster.getMovement(), monster.getHitDice(), monster.getThaco(),
							monster.getAttack(), monster.getSize(), monster.getMorale(), monster.getExperience(),
							// TreasureType-related fields are null because no treasure type
							tt.getTreasureTypeName(), tt.getCopperRange(), tt.getSilverRange(), tt.getGoldRange(),
							tt.getElectrumRange(), tt.getGemsRange(), tt.getArtObjectsRange(), tt.getItem(),
							tt.getPercentageCopper(), tt.getPercentageSilver(), tt.getPercentageGold(),
							tt.getPercentageElectrum(), tt.getPercentageGems(), tt.getPercentageArtObjects(),
							tt.getPercentageItem());
					entryList.add(entryToAdd);
					addedTreasureIds.add(tt.getTreasureTypeId());
				}
			}
		}

		for (TreasureType tt : treasureTypes) {
			if (!addedTreasureIds.contains(tt.getTreasureTypeId())) {
				FullEntry entryToAdd = new FullEntry(null, null, null, null, null, null, null, null, null, null, null,
						null, null,
						// TreasureType-related fields are null because no treasure type
						tt.getTreasureTypeName(), tt.getCopperRange(), tt.getSilverRange(), tt.getGoldRange(),
						tt.getElectrumRange(), tt.getGemsRange(), tt.getArtObjectsRange(), tt.getItem(),
						tt.getPercentageCopper(), tt.getPercentageSilver(), tt.getPercentageGold(),
						tt.getPercentageElectrum(), tt.getPercentageGems(), tt.getPercentageArtObjects(),
						tt.getPercentageItem());
				entryList.add(entryToAdd);
			}
		}

		return entryList;
	}
}