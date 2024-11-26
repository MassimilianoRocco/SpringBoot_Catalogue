package it.test.corsospring.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.test.corsospring.model.Prodotto;
import it.test.corsospring.repository.ProdottoRepository;
import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/prodotto")
public class ProdottoController {
	
	@Autowired
	private ProdottoRepository repo;
	
	@GetMapping("/lista")
	public ModelAndView list() {

		long totaleProdotti = repo.count();
		
		return new ModelAndView("index","listaProdotti", repo.findAll() ).addObject("totaleProdotti", totaleProdotti);
	}
	
	
	@GetMapping("/create")
	public String add(@ModelAttribute("datiProdotto") Prodotto p) {
		
		return "create";
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("datiProdotto") Prodotto p) {
		
		repo.save(p);
		
		return "redirect:/prodotto/lista";
	}
	
	
	@GetMapping("/edit")
	public String edit(@RequestParam("id") String idProdotto, ModelMap mm ) {
		
		Optional<Prodotto> prodottoDaModificare = repo.findById(Integer.parseInt(idProdotto));
		
		if (prodottoDaModificare.isPresent()) {
			mm.addAttribute("prodottoDaModificare", prodottoDaModificare.get());
		}
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String update(@ModelAttribute("datiProdotto") Prodotto p) {
		
		repo.save(p);
		
		return "redirect:/prodotto/lista";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String idProdotto) {
		
		if(idProdotto!=null) {
			repo.deleteById(Integer.parseInt(idProdotto));
		}
		
		return "redirect:/prodotto/lista";
	}
	
	
	//Metodo che parte automaticamente dopo che il contesto Spring ha inizializzato il bean (l'oggetto di questa classe). Creerà 200 records nel database.
//	@PostConstruct
//	public void initDB() {
//		List<Prodotto> prods = IntStream.rangeClosed(1, 200).mapToObj(i->new Prodotto("Gioco"+i, "Nessuna descrizione", new Random().nextInt(100))).collect(Collectors.toList());
//		
//		repo.saveAll(prods);
//	}
}
