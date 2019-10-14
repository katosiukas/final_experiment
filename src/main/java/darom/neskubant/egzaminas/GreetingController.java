package darom.neskubant.egzaminas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/klientas")
	public String klientai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "klientas";
	    
	}
	 
	@GetMapping("/meniu")
	public String meniu(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "meniu";
	    
	}

	@GetMapping("/uzsakymas")
	public String uzsakymas(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "uzsakymas";
	    
	}
}