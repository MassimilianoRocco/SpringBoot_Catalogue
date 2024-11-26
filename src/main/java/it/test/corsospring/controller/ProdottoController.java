package it.test.corsospring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

@Controller
@RequestMapping("/prodotto")
public class ProdottoController {
	
	@Autowired
	private ProdottoRepository repo;
	
	
	
	
	
	@GetMapping("/lista")
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "15") int size) {

		long totaleProdotti = repo.count();
		
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
		Page<Prodotto> prodottiPage = repo.findAll(pageable);
		
		
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("totaleProdotti", totaleProdotti);
	    mav.addObject("listaProdotti", prodottiPage.getContent()); // Lista dei prodotti nella pagina corrente
	    mav.addObject("currentPage", page); // Pagina corrente
	    mav.addObject("totalPages", prodottiPage.getTotalPages()); // Numero totale di pagine
	    return mav;
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
