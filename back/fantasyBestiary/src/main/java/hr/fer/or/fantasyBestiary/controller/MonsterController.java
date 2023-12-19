package hr.fer.or.fantasyBestiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.service.MonsterService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
	
	@PostMapping("/create")
	public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
	    Monster savedMonster = monsterService.saveMonster(monster);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(savedMonster.getMonsterId())
	            .toUri();
	    return ResponseEntity.created(location).body(savedMonster);
	}
	
	@PutMapping("/edit/{id}") 
    public ResponseEntity<Monster> updateMonster(@PathVariable Long id, @RequestBody Monster updatedMonster) {
        Optional<Monster> existingMonsterOptional = monsterService.getMonsterById(id);
        if (existingMonsterOptional.isPresent()) {
        	updatedMonster.setMonsterId(id);
            Monster savedMonster = monsterService.saveMonster(updatedMonster);
            return ResponseEntity.ok(savedMonster);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMonster(@PathVariable Long id) {
        if (monsterService.getMonsterById(id).isPresent()) {
            monsterService.deleteMonster(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
