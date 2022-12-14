package sk.skolenie.kniznica.domain;

/**
 * Trieda Citatel je špeciálnym prípadom Osoby.
 * 
 */
public class Citatel extends Osoba {
	
	/*
	 * Nasledujúce atribúty z triedy Osoba sú zdedené,
	 * čiže obsahuje ich aj trieda Citatel:

	private String meno;
	private String priezvisko;
	private Adresa adresa;
	
	 */

	// Trieda Citatel pridáva nový atribút rodneCislo typu String:
	private String rodneCislo;

	/**
	 * Keď vytváram nový objekt typu Citatel,
	 * musím iniciovať aj atribúty meno a priezviko,
	 * ktoré trieda zdedila od triedy Osoba.
	 * Urobím to tak, že zavolám konštruktor triedy
	 * Osoba a tieto atribúty mu odovzdám.
	 */
	public Citatel(String meno, String priezvisko, String rodneCislo) {
		// Volanie konštruktora triedy Osoba:
		super(meno, priezvisko);
		this.rodneCislo = rodneCislo;
	}

	@Override
	public String toString() {
		return "Citatel [rodneCislo=" + rodneCislo + ", " + super.toString() + "]";
	}

}
