package sk.skolenie.kniznica.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Kniznica implements Serializable {
	private static final long serialVersionUID = -4023637772682429214L;
	
	private final List<CitatelskyPreukaz> citatelskePreukazy;
	private final List<KniznyTitul> knizneTituly;
	private final List<PozickaKnihy> pozicaneKnihy;
	
	private final CitatelskyPreukazRepository citatelskyPreukazRepository;
	
	public Kniznica(CitatelskyPreukazRepository citatelskyPreukazRepository) {
		citatelskePreukazy = new ArrayList<>();
		knizneTituly = new ArrayList<>();
		pozicaneKnihy = new ArrayList<>();
		this.citatelskyPreukazRepository = citatelskyPreukazRepository;
	}
	
	/**
	 * Metóda vytvorí nový čitateľský preukaz pre danú osobu
	 * a zaradí ho do evidencie čitateľských preukazov.
	 */
	public CitatelskyPreukaz vytvorNovyCitatelskyPreukazPre( Osoba osoba ) {
		CitatelskyPreukaz citatelskyPreukaz = new CitatelskyPreukaz(osoba);
		// Zaradenie do evidencie čitateľských preukazov
		citatelskePreukazy.add(citatelskyPreukaz);
		//citatelskyPreukazRepository.create(citatelskyPreukaz);
		return citatelskyPreukaz;
	}

	@Override
	public String toString() {
		String result = "PREUKAZY: \n";
		StringJoiner joiner = new StringJoiner("\n");
		for (CitatelskyPreukaz citatelskyPreukaz : citatelskePreukazy) {
			joiner.add(citatelskyPreukaz.toString());
		}
		result += joiner.toString();
		
		result += "\nKNIHY:\n";
		joiner = new StringJoiner("\n");
		for (KniznyTitul kniha : knizneTituly) {
			joiner.add(kniha.toString() );
		}
		result += joiner.toString();
		
		result += "\nPOZICKY:\n";
		joiner = new StringJoiner("\n");
		for (PozickaKnihy pozickaKnihy : pozicaneKnihy) {
			joiner.add(pozickaKnihy.toString() );
		}
		result += joiner.toString();

		return result;
	}

	public void zaradKnihuDoKniznice(Kniha kniha, int pocet ) {
		KniznyTitul kniznyTitul = new KniznyTitul(kniha, pocet);
		knizneTituly.add( kniznyTitul );
	}

	/**
	 * Metóda vyhľadáva čitateľský preukaz podľa mena a priezviska čitateľa.
	 * Metóda vráti NULL, ak čitateľský preukaz pre danú osobu neexistuje.
	 */
	public CitatelskyPreukaz hladajPodlaMena(String meno, String priezvisko) {
		for (CitatelskyPreukaz citatelskyPreukaz : citatelskePreukazy) {
			if ( citatelskyPreukaz.jePreOsobu(meno, priezvisko) ) {
				return citatelskyPreukaz;
			}
		}
		// Keď sa nenájde čitateľský preukaz,
		// vrátime null.
		return null;
	}

	/**
	 * Metóda vyhľadáva knihu podľa názvu.
	 * Metóda vráti NULL, ak kniha pre daný názov neexistuje.
	 */
	public KniznyTitul hladajPodlaNazvu(String nazovKnihy) {
		for (KniznyTitul kniznyTitul : knizneTituly) {
			if ( kniznyTitul.jePreKnihu(nazovKnihy)) {
				return kniznyTitul;
			}
		}
		
		return null;
	}

	public void pozicajKnihu(KniznyTitul kniznyTitul, CitatelskyPreukaz preukaz ) {
		PozickaKnihy pozickaKnihy = new PozickaKnihy( kniznyTitul.getKniha(), preukaz);
		pozicaneKnihy.add(pozickaKnihy);
		kniznyTitul.pozicaj();
	}

	public void vratKnihu(Kniha kniha, CitatelskyPreukaz preukaz) {
		KniznyTitul kniznyTitul = hladajPodlaNazvu(kniha.getNazov());
		kniznyTitul.vrat();
		PozickaKnihy pozickaKnihy = hladajPozicanuKnihu(kniha, preukaz);
		pozicaneKnihy.remove(pozickaKnihy);
	}
	
	private PozickaKnihy hladajPozicanuKnihu(Kniha kniha, CitatelskyPreukaz preukaz) {
		for (PozickaKnihy pozickaKnihy : pozicaneKnihy) {
			if ( ( pozickaKnihy.getKniha() == kniha )
					&& ( pozickaKnihy.getCitatelskyPreukaz() == preukaz ) ) {
				return pozickaKnihy;
			}
		}
		return null;

		/*
		 * Nasledujúci kód robí to isté, čo FOR-cyklus,
		 * ale pomocou "stream-ov".
		 * Stream-y v Jave umožňujú funkcionálne programovanie.
		 * Nie je nutné to ovládať, ale mnohí programátori
		 * uprednostňujú práve tento prístup.
		 */

//		return pozicaneKnihy.stream()
//				.filter( pozickaKnihy -> pozickaKnihy.getKniha() == kniha )
//				.filter( pozickaKnihy -> pozickaKnihy.getCitatelskyPreukaz() == preukaz )
//				.findAny()
//				.orElse(null);
	}

	public List<Osoba> vratZoznamAutorov() {
		List<Osoba> result = new ArrayList<>();
		
		for (KniznyTitul kniznyTitul : knizneTituly) {
			result.add(kniznyTitul.getAutor());
		}
		
		return result;
		
//		return knizneTituly.stream()
//				.map( kniznyTitul -> kniznyTitul.getAutor() )
//				.toList();
	}

	public List<String> zistiNazvyPozicanychKnih() {
//		List<String> result = new ArrayList<>();
//		
//		for (PozickaKnihy pozickaKnihy : pozicaneKnihy) {
//			result.add( pozickaKnihy.getKniha().getNazov() );
//		}
//		
//		return result;
		return pozicaneKnihy.stream()
				.map( pozickaKnihy -> pozickaKnihy.getKniha().getNazov() )
				.toList();
	}

}
