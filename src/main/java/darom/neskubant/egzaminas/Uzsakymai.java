package darom.neskubant.egzaminas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Uzsakymai {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false)
    private Integer patiekalo_id;
    
	@JsonIgnoreProperties("uzsakymai")
	@ManyToOne(optional=false)
    @JoinColumn(name="patiekalo_id",referencedColumnName="id", insertable=false, updatable=false)
    private Meniu meniu;
	
	@Column(nullable=false)
    private Integer klientoId;
    
	@JsonIgnoreProperties("uzsakymai")
	@ManyToOne(optional=false)
    @JoinColumn(name="klientoId",referencedColumnName="id", insertable=false, updatable=false)
    private Klientas klientas;
	
	
	public Uzsakymai() {
    	
    }
    
	/**
	 * @return the klientas
	 */
	public Klientas getKlientas() {
		return klientas;
	}

	/**
	 * @param klientas the klientas to set
	 */
	public void setKlientas(Klientas klientas) {
		this.klientas = klientas;
	}

	/**
	 * @return the meniu
	 */
	public Meniu getMeniu() {
		return meniu;
	}

	/**
	 * @param meniu the meniu to set
	 */
	public void setMeniu(Meniu meniu) {
		this.meniu = meniu;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the uzsakymo_id
	 */
	public Integer getPatiekalo_id() {
		return patiekalo_id;
	}
	/**
	 * @param uzsakymo_id the uzsakymo_id to set
	 */
	public void setPatiekalo_id(Integer patiekalo_id) {
		this.patiekalo_id = patiekalo_id;
	}

	/**
	 * @return the kliento_id
	 */
	public Integer getKlientoId() {
		return klientoId;
	}

	/**
	 * @param kliento_id the kliento_id to set
	 */
	public void setKlientoId(Integer klientoId) {
		this.klientoId = klientoId;
	}
	
}