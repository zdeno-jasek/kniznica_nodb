package sk.skolenie.kniznica.domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Triedy, ktoré ukladajú dáta, sa obvykle nazývajú Repository.
 * Názov triedy je tvorený názvom dát, ktoré ukladá a príponou Repository.
 * Takže trieda na uloženie objektu Kniznica sa volá KniznicaRepository.
 * 
 * Obvykle sú Repository používané na prístup k dátam v databáze.
 * Ale koncept Repository vo všeobecnosti znamená prístup k akémukoľvek
 * zdroju dát. Čiže napríklad aj k dátam, ktoré sú uložené v súbore.
 * 
 * Keďže táto implementácia Repository pristupuje k údajom v súbore (File),
 * pridáme do jej názvu ešte aj príponu "File".
 * Podobne by sme mohli do implementácie Repository pridať "Database",
 * ak by išlo o Repository, ktorá zapisuje údaje do databázy.
 *
 */
public class KniznicaRepositoryFile {

	public void create(Kniznica kniznica) {
		String file = "kniznica.txt";
		try (
				FileOutputStream output = new FileOutputStream(file);
				ObjectOutputStream objectOut = new ObjectOutputStream(output);
				) 
		{
			objectOut.writeObject(kniznica);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Kniznica read() {
		Kniznica result = null;
		String file = "kniznica.txt";
		try (
				FileInputStream input = new FileInputStream(file);
				ObjectInputStream objectIn = new ObjectInputStream(input);
				) 
		{
			result = (Kniznica) objectIn.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
