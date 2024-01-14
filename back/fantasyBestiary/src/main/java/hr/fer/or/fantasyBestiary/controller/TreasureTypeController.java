package hr.fer.or.fantasyBestiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.response.ApiResponse;
import hr.fer.or.fantasyBestiary.service.TreasureTypeService;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> getTreasureTypeById(@PathVariable Long id) {
        Optional<TreasureType> treasureTypeOptional = treasureTypeService.getTreasureTypeById(id);
        if (treasureTypeOptional.isPresent()) {
            TreasureType treasureType = treasureTypeOptional.get();
            ApiResponse<TreasureType> response = new ApiResponse<>("success", treasureType, "treasure");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("error", null, "null"));
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllTreasureTypes() {
        List<TreasureType> treasureTypes = treasureTypeService.getAllTreasureTypes();
        if (treasureTypes != null && !treasureTypes.isEmpty()) {
            ApiResponse<List<TreasureType>> response = new ApiResponse<>("success", treasureTypes, "treasure");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("error", null, "null"));
        }
    }
    
}
