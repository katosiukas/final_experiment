package darom.neskubant.egzaminas;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Klientas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String vardas;
	private String pavarde;
	private Integer alkoholis;
	private Integer riesutai;
	private Integer pienas;
	
	@OneToMany(mappedBy = "klientas",cascade = CascadeType.ALL)
	private List<Uzsakymai> uzsakymai;
	
	public Klientas() {}

	public Klientas(String vardas, String pavarde, Integer alkoholis, Integer riesutai, Integer pienas) {
		
		this.vardas = vardas;
		this.pavarde = pavarde;
		this.alkoholis = alkoholis;
		this.riesutai = riesutai;
		this.pienas = pienas;
		
	}
			
	/**
	 * @return the uzsakymai
	 */
	public List<Uzsakymai> getUzsakymai() {
		return uzsakymai;
	}

	/**
	 * @param uzsakymai the uzsakymai to set
	 */
	public void setUzsakymai(List<Uzsakymai> uzsakymai) {
		this.uzsakymai = uzsakymai;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the vardas
	 */
	public String getVardas() {
		return vardas;
	}
	/**
	 * @param vardas the vardas to set
	 */
	public void setVardas(String vardas) {
		this.vardas = vardas;
	}
	/**
	 * @return the pavarde
	 */
	public String getPavarde() {
		return pavarde;
	}
	/**
	 * @param pavarde the pavarde to set
	 */
	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}
	/**
	 * @return the alkoholis
	 */
	public Integer getAlkoholis() {
		return alkoholis;
	}
	/**
	 * @param alkoholis the alkoholis to set
	 */
	public void setAlkoholis(Integer alkoholis) {
		this.alkoholis = alkoholis;
	}
	/**
	 * @return the riesutai
	 */
	public Integer getRiesutai() {
		return riesutai;
	}
	/**
	 * @param riestutai the riestutai to set
	 */
	public void setRiesutai(Integer riesutai) {
		this.riesutai = riesutai;
	}
	/**
	 * @return the pienas
	 */
	public Integer getPienas() {
		return pienas;
	}
	/**
	 * @param pienas the pienas to set
	 */
	public void setPienas(Integer pienas) {
		this.pienas = pienas;
	}

	@Override
	public String toString() {
		return "Klientas [id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + ", alkoholis=" + alkoholis
				+ ", riesutai=" + riesutai + ", pienas=" + pienas + "]";
	}
		
}	