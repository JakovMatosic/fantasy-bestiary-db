package hr.fer.or.fantasyBestiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.fer.or.fantasyBestiary.entities.Monster;
import hr.fer.or.fantasyBestiary.entities.TreasureType;

public interface MonsterRepository extends JpaRepository<Monster, Long> {

	@Query("SELECT mt.treasureType FROM MonsterTreasure mt WHERE mt.monster.monsterId = :monsterId")
	List<TreasureType> findTreasuresByMonsterId(@Param("monsterId") Long monsterId);

}
