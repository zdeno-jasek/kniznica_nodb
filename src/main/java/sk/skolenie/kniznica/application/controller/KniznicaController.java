package sk.skolenie.kniznica.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.skolenie.kniznica.application.dto.DTOOsoba;
import sk.skolenie.kniznica.domain.Kniznica;
import sk.skolenie.kniznica.domain.KniznicaFactory;
import sk.skolenie.kniznica.domain.KniznyTitul;
import sk.skolenie.kniznica.domain.Osoba;

@Controller
@RequestMapping(value = "/kniznica")
public class KniznicaController {
	private Kniznica kniznica;

	public KniznicaController() {
		kniznica = KniznicaFactory.create();
	}

	@GetMapping(value = "/knihy/{nazovKnihy}")
	public @ResponseBody KniznyTitul getKniznyTitul(@PathVariable String nazovKnihy) {
		return kniznica.hladajPodlaNazvu(nazovKnihy);
	}

	@PostMapping(value = "/preukazy")
	public @ResponseBody String createPreukaz(@RequestBody DTOOsoba dtoOsoba) {
		Osoba osoba = new Osoba(dtoOsoba.meno, dtoOsoba.priezvisko);
		return kniznica.vytvorNovyCitatelskyPreukazPre(osoba).getCislo();
	}

	@GetMapping(value = "/")
	public @ResponseBody String showAll() {
		return kniznica.toString();
	}

}
