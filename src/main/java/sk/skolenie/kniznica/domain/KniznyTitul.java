package sk.skolenie.kniznica.domain;

import java.io.Serializable;

public class KniznyTitul implements Serializable {

	private static final long serialVersionUID = -6791080146838719786L;
	
	private Kniha kniha;
	private int pocet;

	public KniznyTitul(Kniha kniha, int pocetKusov) {
		this.kniha = kniha;
		this.pocet = pocetKusov;
	}

	@Override
	public String toString() {
		return "KniznyTitul [kniha=" + kniha + ", pocetKusov=" + pocet + "]";
	}

	public void pozicaj() {
		pocet--;
	}

	public void vrat() {
		pocet++;
	}

	public boolean jePreKnihu(String nazovKnihy) {
		return kniha.getNazov().equals(nazovKnihy);
	}

	public Kniha getKniha() {
		return kniha;
	}
	
	public Osoba getAutor() {
		return kniha.getAutor();
	}

}
