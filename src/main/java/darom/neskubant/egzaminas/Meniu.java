package darom.neskubant.egzaminas;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Meniu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pavadinimas;
	private Integer yrariesutu;
	private Integer yrapieno;

	@OneToMany(mappedBy = "meniu",cascade = CascadeType.ALL)
	 private List<Uzsakymai> uzsakymai;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * @return the yrariesutu
	 */
	public Integer getYrariesutu() {
		return yrariesutu;
	}
	/**
	 * @param yrariesutu the yrariesutu to set
	 */
	public void setYrariesutu(Integer yrariesutu) {
		this.yrariesutu = yrariesutu;
	}
	/**
	 * @return the yrapieno
	 */
	public Integer getYrapieno() {
		return yrapieno;
	}
	/**
	 * @param yrapieno the yrapieno to set
	 */
	public void setYrapieno(Integer yrapieno) {
		this.yrapieno = yrapieno;
	}
	
}