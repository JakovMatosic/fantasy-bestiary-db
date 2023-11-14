package hr.fer.or.fantasyBestiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.fer.or.fantasyBestiary.entities.TreasureType;

public interface TreasureTypeRepository extends JpaRepository<TreasureType, Long> {

    // Add custom queries for TreasureType if needed

}
