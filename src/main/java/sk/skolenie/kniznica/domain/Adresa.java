package sk.skolenie.kniznica.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresa implements Serializable {
	private static final long serialVersionUID = 3737239778730398646L;
	
	@Column
	private String ulica;
	@Column
	private String psc;
	@Column
	private String obec;
	
	public Adresa(String ulica, String psc, String obec) {
		this.ulica = ulica;
		this.psc = psc;
		this.obec = obec;
	}

	@Override
	public String toString() {
		return "Adresa [ulica=" + ulica + ", psc=" + psc + ", obec=" + obec + "]";
	}

}
