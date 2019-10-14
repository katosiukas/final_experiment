package darom.neskubant.egzaminas;

import java.util.List;

public class DuomenuApjungimas {
	
	private Klientas klientas;
	private List<KlientoPatiekalai> klientopatiekalai;
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
	 * @return the klientopatiekalai
	 */
	public List<KlientoPatiekalai> getKlientopatiekalai() {
		return klientopatiekalai;
	}
	/**
	 * @param klientopatiekalai the klientopatiekalai to set
	 */
	public void setKlientopatiekalai(List<KlientoPatiekalai> klientopatiekalai) {
		this.klientopatiekalai = klientopatiekalai;
	}
	

}
