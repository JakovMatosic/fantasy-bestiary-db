package hr.fer.or.fantasyBestiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.service.MonsterService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/monsters")
@CrossOrigin(origins = "http://localhost:4200")
public class MonsterController {

	private final MonsterService monsterService;

	@Autowired
	public MonsterController(MonsterService monsterService) {
		this.monsterService = monsterService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Monster> getMonsterById(@PathVariable Long id) {
		Optional<Monster> monsterOptional = monsterService.getMonsterById(id);
		return monsterOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<Monster> getAllMonsters() {
		return monsterService.getAllMonsters();
	}

	@GetMapping("/{monsterId}/treasures")
	public ResponseEntity<List<TreasureType>> getTreasuresForMonster(@PathVariable Long monsterId) {
		List<TreasureType> treasures = monsterService.findTreasuresByMonsterId(monsterId);
		return treasures != null && !treasures.isEmpty() ? ResponseEntity.ok(treasures)
				: ResponseEntity.notFound().build();
	}
}
