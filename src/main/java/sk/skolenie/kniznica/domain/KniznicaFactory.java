package sk.skolenie.kniznica.domain;

/**
 * Trieda má suffix "Factory", pretože ide o tzv. "factory-triedu".
 * Factory-triedy sa používajú na vytváranie objektov,
 * ktorých vytvorenie by bolo náročné a obsahovalo by veľa kódu.
 * V takom prípade nedávame celý kód pre vytvorenie objektu do konštruktora,
 * ale vyrobíme si triedu typu "Factory".
 */
public class KniznicaFactory {
	
	/**
	 * Metóda na vytvorenie objektu typu Kniznica.
	 * Objekt obsahuje zaradené knihy do knižnice
	 * a obsahuje aj vytvorené čitateľské preukazy.
	 */
	public static Kniznica create() {
		Kniznica kniznica = new Kniznica();
		
		vytvorCitatelskePreukazy(kniznica);
		vytvorKnihy(kniznica);
		
		return kniznica;
	}
	
	private static void vytvorKnihy(Kniznica kniznica) {
		kniznica.zaradKnihuDoKniznice( new Kniha( new Osoba( "Karl", "May"), "Winetou"), 3);
		kniznica.zaradKnihuDoKniznice( new Kniha( new Osoba( "Frank", "Herbert"), "Duna"), 1 );
		kniznica.zaradKnihuDoKniznice( new Kniha( new Osoba( "Isaac", "Asimov"), "Nadace"), 10);
	}

	private static void vytvorCitatelskePreukazy( Kniznica kniznica ) {
		Osoba jano = new Osoba( "Jano", "Dlhý" );
		jano.setAdresa(new Adresa( "Agátova 19", "900 42", "Dunajská Lužná" ));
		kniznica.vytvorNovyCitatelskyPreukazPre(jano);
		
		Osoba alica = new Osoba( "Alica", "Snová" );
		alica.setAdresa(new Adresa( "Šášovská 6", "851 06", "Bratislava" ));
		kniznica.vytvorNovyCitatelskyPreukazPre(alica);		

		Osoba peter = new Osoba( "Peter", "Krátky" );
		peter.setAdresa(new Adresa( "Šášovská 6", "851 06", "Bratislava" ));
		kniznica.vytvorNovyCitatelskyPreukazPre(peter);		
	}

}
