package hr.fer.or.fantasyBestiary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.or.fantasyBestiary.entities.FullEntry;
import hr.fer.or.fantasyBestiary.service.MonsterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilController {

	private final MonsterService monsterService;
	
	@Autowired
	public UtilController(MonsterService monsterService) {
		this.monsterService = monsterService;
	}
	
	@GetMapping
	public List<FullEntry> getAllEntries() {
		return monsterService.getAllEntries();
	}
}
