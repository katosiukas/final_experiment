package darom.neskubant.egzaminas;

import java.io.Serializable;
import javax.persistence.Id;

public class KlientoPatiekalai implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String pavadinimas;
	private Integer	uzsakymu;
	
	public KlientoPatiekalai() {
		
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
	 * @return the pavadinimas
	 */
	public String getPavadinimas() {
		return pavadinimas;
	}
	/**
	 * @param pavadinimas the pavadinimas to set
	 */
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	/**
	 * @return the uzsakymu
	 */
	public Integer getUzsakymu() {
		return uzsakymu;
	}
	/**
	 * @param uzsakymu the uzsakymu to set
	 */
	public void setUzsakymu(Integer uzsakymu) {
		this.uzsakymu = uzsakymu;
	}
	
	
}
