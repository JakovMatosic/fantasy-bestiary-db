package hr.fer.or.fantasyBestiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.service.TreasureTypeService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/treasure-types")
@CrossOrigin(origins = "http://localhost:4200")
public class TreasureTypeController {

    private final TreasureTypeService treasureTypeService;

    @Autowired
    public TreasureTypeController(TreasureTypeService treasureTypeService) {
        this.treasureTypeService = treasureTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreasureType> getTreasureTypeById(@PathVariable Long id) {
        Optional<TreasureType> treasureTypeOptional = treasureTypeService.getTreasureTypeById(id);
        return treasureTypeOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<TreasureType> getAllTreasureTypes() {
        return treasureTypeService.getAllTreasureTypes();
    }

//    @GetMapping("/{treasureTypeId}/monsters")
//    public ResponseEntity<Set<Monster>> getMonstersByTreasureTypeId(@PathVariable Long treasureTypeId) {
//        Set<Monster> monsters = treasureTypeService.getMonstersByTreasureTypeId(treasureTypeId);
//        return monsters != null ? ResponseEntity.ok(monsters) : ResponseEntity.notFound().build();
//    }
}
