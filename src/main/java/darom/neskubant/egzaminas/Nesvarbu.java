package darom.neskubant.egzaminas;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Nesvarbu {
		
	  protected Session em;
	  protected EntityManagerFactory factory;	
		
	  public SessionFactory sessionFactory() {
			
	        if (this.factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
		        return this.factory.unwrap(SessionFactory.class);
		}	
	  
	  public Nesvarbu(EntityManagerFactory factory) {
		  
		  this.factory = factory; 
		  this.em = this.sessionFactory().openSession(); 
				
	  }				
	
	  public List<KlientoPatiekalai> minMaxPatiekalai( Integer kliento_id ) {
		  
		  String qw_top_patieklai =
	  				
	  		" ( SELECT "
	  		+ 	"meniu.id AS id, "
	  		+ 	"meniu.pavadinimas AS pavadinimas, "
	  		+ 	"COUNT(*) AS uzsakymu "
	  		+ "FROM "
	  		+ 	"uzsakymai AS kliento_patiekalai "
	  		+ "LEFT JOIN "
	  		+ 	"meniu ON (meniu.id=kliento_patiekalai.patiekalo_id) "
	  		+ "WHERE kliento_patiekalai.kliento_id=" + kliento_id + " "
	  		+ "GROUP BY "
	  		+ 	"kliento_patiekalai.patiekalo_id "
	  		+ "ORDER BY uzsakymu DESC LIMIT 1 "
	  		+ " ) UNION ("
	  		+ "SELECT "
	  		+ 	"meniu.id AS id, "
	  		+ 	"meniu.pavadinimas AS pavadinimas, "
	  		+ 	"COUNT(uzsakymai.id) AS uzsakymu "
	  		+ "FROM "
	  		+ 	"meniu "
	  		+ "LEFT JOIN "
	  		+ 	"uzsakymai ON ("
	  		+ 		"meniu.id=uzsakymai.patiekalo_id"
	  		+     " AND "
	  		+       "uzsakymai.kliento_id=" + kliento_id + " "
	  		+ ") "
			+ "LEFT JOIN "
			+ "		`klientas` ON ( "
			
			+ 			"`klientas`.`id`=" + kliento_id 
			+ 		" ) "	  		
	  		+ " WHERE"
	  		+ " ( NOT klientas.riesutai ) OR ( NOT meniu.yrariesutu )"
	  		+ " AND "
	  		+ "	( NOT klientas.pienas ) OR ( NOT meniu.yrapieno )"
	  		+ " GROUP BY "
	  		+ 	"meniu.id "
	  		+ " ORDER BY uzsakymu ASC LIMIT 1 "
	  		+ ")"
	  		+ "" 
				;
	  	System.out.println ( qw_top_patieklai );
	    Query<KlientoPatiekalai> query = em.createNativeQuery ( qw_top_patieklai );

	    return (List<KlientoPatiekalai>) query.getResultList();
  }	  			

}