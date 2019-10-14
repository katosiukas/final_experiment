package darom.neskubant.egzaminas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;

@Controller    
@RequestMapping(path="/restfull") 
public class MainController {
	
	@Autowired 
	EntityManagerFactory factory;
	
	@Autowired         	
	private KlientasRepository KlientasRepository;
	
	@Autowired
	private MeniuRepository MeniuRepository;
	
	@Autowired
	private UzsakymaiRepository UzsakymaiRepository;
	
	// Klientai SQL valdymas
	
	@GetMapping(path="/all_klientai")
	public @ResponseBody Iterable<Klientas> getAllKlientai() {
		
		return KlientasRepository.findAll();
	}
	
	@GetMapping(path="/klientas")
	public @ResponseBody DuomenuApjungimas nesvarbu(@RequestParam Integer id) {	
		
		Nesvarbu nesvarbu = new Nesvarbu(factory);
		       		
		DuomenuApjungimas duomenuapjungimas = new DuomenuApjungimas();
					
		duomenuapjungimas.setKlientas( KlientasRepository.findById (id).get());
		duomenuapjungimas.setKlientopatiekalai(nesvarbu.minMaxPatiekalai(id ));
		
		return duomenuapjungimas;
	}
	
	@GetMapping(path="/prideti_klienta") 
	public @ResponseBody String addNewKlientas (@RequestParam String vardas
			, @RequestParam String pavarde
			, @RequestParam Integer alkoholis
			, @RequestParam Integer riesutai
			, @RequestParam Integer pienas)
			{
				
		Klientas n = new Klientas();
		n.setVardas(vardas);
		n.setPavarde(pavarde);
		n.setAlkoholis(alkoholis);
		n.setRiesutai(riesutai);
		n.setPienas(pienas);

		String rezultatas = "issaugota"; 
		
		try {
			
			KlientasRepository.save(n);
			
		} catch( Exception e ) {
			
			
			rezultatas = "not";
		
		}
		
		return rezultatas;
	}
	
	@GetMapping(path="/redaguoti_klienta") 
	public @ResponseBody String redaguotiklienta (@RequestParam Integer id
			, @RequestParam String vardas
			, @RequestParam String pavarde
			, @RequestParam Integer alkoholis
			, @RequestParam Integer riesutai
			, @RequestParam Integer pienas)
			{
				
		Optional <Klientas> found = KlientasRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Klientas n = found.get();
			   n.setId(id);
			   n.setVardas(vardas);
			   n.setPavarde(pavarde);
			   n.setAlkoholis(alkoholis);
			   n.setRiesutai(riesutai);
			   n.setPienas(pienas);
			   KlientasRepository.save(n);	
			 
			   			}
		return res;
	}
	
	@GetMapping(path="/trinti_klienta") 
	public @ResponseBody String klientas (@RequestParam Integer id ) {
				
		Optional <Klientas> found = KlientasRepository.findById( id );
		
		String res = "Not done";
		Klientas n = found.get();
		n.setId(id);
		KlientasRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	// Restorano meniu SQL valdymas	
	
	@GetMapping(path="/all_meniu")
	public @ResponseBody Iterable<Meniu> getAllMeniu() {
		
		return MeniuRepository.findAll();
	}
	
	@GetMapping(path="/patiekalas")
	public @ResponseBody Optional<Meniu> Meniu(@RequestParam Integer id) {
		
		return MeniuRepository.findById (id);
	}
	
	@GetMapping(path="/prideti_patiekala") 
	public @ResponseBody String addNewPatiekalas (@RequestParam String pavadinimas
			, @RequestParam Integer yrariesutu
			, @RequestParam Integer yrapieno)
			{
				
		Meniu n = new Meniu();
		n.setPavadinimas(pavadinimas);
		n.setYrariesutu(yrariesutu);
		n.setYrapieno(yrapieno);
		MeniuRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/redaguoti_patiekala") 
	public @ResponseBody String redaguotipatiekala (@RequestParam Integer id
			, @RequestParam String pavadinimas
			, @RequestParam Integer yrariesutu
			, @RequestParam Integer yrapieno)
			{
				
		Optional <Meniu> found = MeniuRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Meniu n = found.get();
			   n.setId(id);
			   n.setPavadinimas(pavadinimas);
			   n.setYrariesutu(yrariesutu);
			   n.setYrapieno(yrapieno);
			   MeniuRepository.save(n);	
			   res = "Saved"; 
			   			}
		return res;
	}
	
	@GetMapping(path="/trinti_patiekala") 
	public @ResponseBody String patiekalas (@RequestParam Integer id ) {
				
		Optional <Meniu> found = MeniuRepository.findById( id );
		
		String res = "Not done";
		Meniu n = found.get();
		n.setId(id);
		MeniuRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	// Uzsakymu SQL valdymas
	
	@GetMapping(path="/all_uzsakymai")
	public @ResponseBody Iterable<Uzsakymai> getAllUzsakymai() {
		
		return UzsakymaiRepository.findAll();
	}
	
	@GetMapping(path="/uzsakymas")
	public @ResponseBody List<Uzsakymai> Uzsakymai(@RequestParam Integer kliento_id) {
		
		return UzsakymaiRepository.findByKlientoId (kliento_id);
	}
	
	@GetMapping(path="/prideti_uzsakyma") 
	public @ResponseBody String addNewUzsakymas (@RequestParam Integer kliento_id
			, @RequestParam Integer patiekalo_id)
			{
				
		Uzsakymai n = new Uzsakymai();
		n.setKlientoId(kliento_id);
		n.setPatiekalo_id(patiekalo_id);
		UzsakymaiRepository.save(n);
		return "Saved";
	}
}