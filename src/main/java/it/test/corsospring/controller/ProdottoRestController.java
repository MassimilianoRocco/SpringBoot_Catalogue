package it.test.corsospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.test.corsospring.model.Prodotto;
import it.test.corsospring.repository.ProdottoRepository;


@RestController
@RequestMapping("/prodottorest")
public class ProdottoRestController {

	@Autowired
	private ProdottoRepository repo;
	
	@GetMapping("/list")
	public Iterable<Prodotto> getProdotti() {
		return repo.findAll();
		
	}
	
	@GetMapping("/prodotto/{id}")
	public Prodotto getProdotto(@PathVariable int id) {
		return repo.findById(id).get();
	}
	
	
	@PostMapping("/add")
	public Prodotto add(@RequestBody Prodotto p) {
		return repo.save(p);
	}
	
}
