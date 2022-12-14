package sk.skolenie.kniznica.domain;

import java.io.Serializable;

public class Adresa implements Serializable {
	private static final long serialVersionUID = 3737239778730398646L;
	
	private String ulica;
	private String psc;
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
