package darom.neskubant.egzaminas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EgzaminasApplicationTests {

	 @Autowired
	 private KlientasRepository klientasRepository;
	 
	 @Test
	 public void testSaveGetKlientas() {
	 
		 Klientas klientas = new Klientas("Vardenisas", "Pavardenisas", 1, 1, 0);
	     Klientas klient = klientasRepository.save(klientas);
	     Klientas kli = klientasRepository.findByVardas("Vardenisas");
	        																			        
	     assertNotNull(klientas);
	        																			        
	     assertNotNull(kli);        
	        																			         
	     assertEquals(kli.getVardas(), klientas.getVardas());
	        																				
	     assertEquals(kli.getPavarde(), klientas.getPavarde());
	        																				     
	     klientasRepository.deleteById(klient.getId());        					  
	     System.out.println (" testo pabaiga ");
	 
	 }
	 
	 @Test
	 public void testFindAllKlientai() {
		 
	    assertNotNull(klientasRepository.findAll());
	    
	 }
	 
	 @Test    
	 public void deleteFoundedByName() {
	        																			       
		 Klientas klientas = new Klientas( "Vardenis", "Pavardenis", 1, 1, 0);        
		 klientasRepository.delete(klientas);                  					  
	 }    

	 @Test
	 public void deletByKlientasIdTest() {
	    	
		 Klientas klientas = new Klientas( "Jonasas", "Jonaitisas", 1, 0, 1);    	
	     Klientas kli = klientasRepository.save(klientas);
	     klientasRepository.deleteById(kli.getId());
	     
	 }   
	 
}