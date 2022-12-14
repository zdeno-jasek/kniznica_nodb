package sk.skolenie.kniznica.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CitatelskyPreukaz implements Serializable {
	private static final long serialVersionUID = 5199364011508607400L;

	private static int cislovacPreukazov = 1;

	// Modifikátor "final" hovorí, že tento atribút sa nastaví v konštruktore
	// a už sa nikdy nezmení počas trvania života tohto objektu.
	// Je dobré vkladať objektom zodpovednosť za konzistenciu a správnosť dát.
	private String cisloPreukazu;
	private Osoba osoba;
	private LocalDate platnyOd;
	private LocalDate platnyDo;
	
	/**
	 * Konštruktor na vstupe očakáva iba osobu, pre ktorú sa má vytvoriť čitateľský preukaz.
	 * Konštruktor automaticky nastaví číslo preukazu a platnosť čitateľského preukazu.
	 */
	public CitatelskyPreukaz(Osoba osoba) {
		// "Defenzívne programovanie" je názov pre taký štýl programovania,
		// v ktorom programátor nepripustí, aby ním vytvorené objekty boli nekonzistentné.
		// Napríklad čitateľský preukaz nemôže byť vystavený,
		// ak nie je zadaná osoba.
		// Preto treba hneď na začiatku skontrolovať,
		// či vo volaní konštruktora neprišiel NULL.
		Objects.requireNonNull(osoba);
		this.cisloPreukazu = String.format( "%05d/%ty", cislovacPreukazov++, LocalDate.now() );
		this.osoba = osoba;
		this.platnyOd = LocalDate.now();
		this.platnyDo = LocalDate.of(3000, 1, 1);
	}

	@Override
	public String toString() {
		return "CitatelskyPreukaz [cisloPreukazu=" + cisloPreukazu + ", osoba=" + osoba + ", platnyOd=" + platnyOd
				+ ", platnyDo=" + platnyDo + "]";
	}

	/**
	 * Metóda vráti TRUE, ak je čitateľský preukaz práve teraz platný.
	 * tell, don't ask
	 */
	public boolean isPlatny() {
		LocalDate now = LocalDate.now();
		// platnyOd <= now < platnyDo
		return ( now.equals(platnyOd) || now.isAfter(platnyOd) ) && now.isBefore(platnyDo);
	}

	public boolean jePreOsobu(String meno, String priezvisko) {
		// Porovnávanie objektov (napr. aj String) robíme vždy pomocou equals
		//     osoba.getMeno()     == meno  && osoba.getPriezvisko() ==     priezvisko
		return osoba.getMeno().equals(meno) && osoba.getPriezvisko().equals(priezvisko);
	}

	public String getCislo() {
		return cisloPreukazu;
	}

}
