package sk.skolenie.kniznica.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.skolenie.kniznica.domain.Kniznica;
import sk.skolenie.kniznica.domain.KniznicaFactory;
import sk.skolenie.kniznica.domain.KniznyTitul;

@Controller
@RequestMapping(value = "/kniha")
public class KniznicaController {
	
	 @GetMapping(value = "/{nazovKnihy}")
    public @ResponseBody KniznyTitul getTestData(@PathVariable String nazovKnihy) {
    	Kniznica kniznica = KniznicaFactory.create();
        return kniznica.hladajPodlaNazvu( nazovKnihy );
    }

}
