package sk.skolenie.kniznica.domain;

import java.io.Serializable;

/**
 * Trieda je dátová štruktúra, ktorá má navyše aj chovanie (čiže metódy).
 * Príkladom triedy v Jave je BigDecimal. Táto trieda drží hodnotu,
 * ale zároveň poskytuje aj metódy, ako sa dá s touto hodnotou pracovať.
 * Napríklad BigDecimal.add je metóda, ktorá umožňuje spočítavať.
 * 
 * Trieda Osoba je definovaná tak, aby držala informácie o osobe. 
 */
public class Osoba implements Serializable{

	private static final long serialVersionUID = 3650255950534710171L;

	/**
	 * Trieda obsahuje atribúty.
	 * Atribút vyzerá ako premenná, ale je definovaný na úrovni triedy, nie vo vnútri metódy.
	 * Každý atribút má názov ("meno") a typ ("String") - rovnako ako premenná.
	 * Každý atribút má aj svoju viditeľnosť. Viditeľnosť určuje, či je atribút dostupný aj zvonku.
	 * Obvykle sa pri atribútoch používa slovo "private", čo znamená, že atribút je viditeľný iba vo vnútri triedy.
	 * Viditeľnosť atribútu je definovaná rovnako ako viditeľnosť metódy.
	 */
	private String meno;
	
	/**
	 * Hodnota každého atribútu String je na začiatku "null".
	 * Znamená to, že do atribútu ešte nebolo nič priradené.
	 */
	private String priezvisko;

	private Adresa adresa;

	/**
	 * Konštruktor je špeciálna metóda, ktorá sa volá na začiatku pri vytváraní triedy.
	 * Je veľmi dobrá taktika vytvárať konštruktory, ktoré nastavia kľúčové atribúty
	 * triedy hneď pri vytváraní objektu.
	 * 
	 * V tomto konštruktore prichádzajú na vstupe dva Stringy - meno a priezvisko.
	 * Tieto stringy sa priradia do atribútov objektu: meno a priezvisko.
	 */
	public Osoba(String meno, String priezvisko) {
		// "meno" označuje názov vstupného atribútu,
		// ale aj názov vstupného parametra.
		// Aby bolo možné rozlíšiť, čo je čo,
		// použije sa slovíčko "this" pre prístup k atribútu objektu.
		this.meno = meno;
		this.priezvisko = priezvisko;
	}
	
	public Osoba() {
	}
	
	public void setMeno(String meno) {
		this.meno = meno;
	}

	/**
	 * Keďže atribúty sú "private", nie je možný prístup k nim z inej triedy.
	 * Na prístup k atribútom triedy sa obvykle definujú get-metódy.
	 * Napríklad k atribútu "meno" existuje metóda getMeno().
	 * Metódam, ktoré sprístupňujú hodnoty atribútov, sa hovorí aj "getre" (getters).
	 * Getre majú obvykle jediný riadok: return <atribút>
	 */
	public String getMeno() {
		return meno;
	}

	public String getPriezvisko() {
		return priezvisko;
	}

	@Override
	public String toString() {
		return "Osoba [meno=" + meno + ", priezvisko=" + priezvisko + ", adresa=" + adresa + "]";
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

}
