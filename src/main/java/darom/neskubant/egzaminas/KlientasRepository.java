package darom.neskubant.egzaminas;

import org.springframework.data.repository.CrudRepository;

public interface KlientasRepository extends CrudRepository<Klientas, Integer> {
	
	Klientas findByVardas(String vardas);

}