package hr.fer.or.fantasyBestiary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.entities.TreasureType;
import hr.fer.or.fantasyBestiary.repository.MonsterRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MonsterService {

    private final MonsterRepository monsterRepository;

    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
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
    
}