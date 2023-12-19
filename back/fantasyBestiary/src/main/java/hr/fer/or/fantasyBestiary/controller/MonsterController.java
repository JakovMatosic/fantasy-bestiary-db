package hr.fer.or.fantasyBestiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<Monster>> getMonsterById(@PathVariable Long id) {
        Optional<Monster> monsterOptional = monsterService.getMonsterById(id);
        if (monsterOptional.isPresent()) {
            Monster monster = monsterOptional.get();
            ApiResponse<Monster> response = new ApiResponse<>("success", monster);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("error", null));
        }
    }

	@GetMapping
    public ResponseEntity<ApiResponse<List<Monster>>> getAllMonsters() {
        List<Monster> monsters = monsterService.getAllMonsters();
        ApiResponse<List<Monster>> response = new ApiResponse<>("success", monsters);
        return ResponseEntity.ok(response);
    }

	@GetMapping("/{monsterId}/treasures")
	public ResponseEntity<Object> getTreasuresForMonster(@PathVariable Long monsterId) {
	    List<TreasureType> treasures = monsterService.findTreasuresByMonsterId(monsterId);
	    if (treasures != null && !treasures.isEmpty()) {
	        ApiResponse<List<TreasureType>> response = new ApiResponse<>("success", treasures);
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new ApiResponse<>("error", null));
	    }
	}
	
	@PostMapping("/create")
    public ResponseEntity<ApiResponse<Monster>> createMonster(@RequestBody Monster monster) {
        Monster savedMonster = monsterService.saveMonster(monster);
        ApiResponse<Monster> response = new ApiResponse<>("success", savedMonster);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMonster.getMonsterId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
	
	@PutMapping("/edit/{id}")
    public ResponseEntity<ApiResponse<Monster>> updateMonster(@PathVariable Long id, @RequestBody Monster updatedMonster) {
        Optional<Monster> existingMonsterOptional = monsterService.getMonsterById(id);
        if (existingMonsterOptional.isPresent()) {
            updatedMonster.setMonsterId(id);
            Monster savedMonster = monsterService.saveMonster(updatedMonster);
            ApiResponse<Monster> response = new ApiResponse<>("success", savedMonster);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("error", null));
        }
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMonster(@PathVariable Long id) {
	    if (monsterService.getMonsterById(id).isPresent()) {
	        monsterService.deleteMonster(id);
	        ApiResponse<Void> response = new ApiResponse<>("success", null);
	        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	    } else {
	        ApiResponse<Void> response = new ApiResponse<>("error", null);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	}
}
