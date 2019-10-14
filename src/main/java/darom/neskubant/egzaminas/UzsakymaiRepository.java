package darom.neskubant.egzaminas;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface UzsakymaiRepository extends CrudRepository<Uzsakymai, Integer> {
	
	List<Uzsakymai> findByKlientoId(Integer klientoId);
	
	//@Query("SELECT `meniu`.`id`, `meniu`.`pavadinimas`, COUNT(*) AS `uzsakymu` FROM `uzsakymai`  LEFT JOIN `meniu` ON (`meniu`.`id`=`uzsakymai`.`patiekalo_id`) WHERE `uzsakymai`.`kliento_id`=?1 GROUP BY `uzsakymai`.`patiekalo_id`", nativeQuery = true)
	//String[][] MinMaxPatiekalai( Integer klientoId);
	//	"SELECT meniu.id, meniu.pavadinimas, COUNT(*) AS uzsakymu FROM uzsakymai  LEFT JOIN meniu ON (meniu.id=uzsakymai.patiekalo_id) WHERE uzsakymai.kliento_id=?1 GROUP BY uzsakymai.patiekalo_id"
}