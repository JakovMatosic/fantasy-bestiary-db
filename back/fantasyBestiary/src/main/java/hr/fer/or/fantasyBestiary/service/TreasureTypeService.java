package hr.fer.or.fantasyBestiary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.repository.TreasureTypeRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TreasureTypeService {

    private final TreasureTypeRepository treasureTypeRepository;

    @Autowired
    public TreasureTypeService(TreasureTypeRepository treasureTypeRepository) {
        this.treasureTypeRepository = treasureTypeRepository;
    }

    public Optional<TreasureType> getTreasureTypeById(Long id) {
        return treasureTypeRepository.findById(id);
    }

    public List<TreasureType> getAllTreasureTypes() {
        return treasureTypeRepository.findAll();
    }

//    public Set<Monster> getMonstersByTreasureTypeId(Long treasureTypeId) {
//        Optional<TreasureType> treasureTypeOptional = treasureTypeRepository.findById(treasureTypeId);
//
//        return treasureTypeOptional.map(TreasureType::getMonsters).orElse(null);
//    }

}