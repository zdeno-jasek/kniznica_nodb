package sk.skolenie.kniznica.application.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sk.skolenie.kniznica.domain.CitatelskyPreukaz;
import sk.skolenie.kniznica.domain.CitatelskyPreukazRepository;

@Repository
public class CitatelskyPreukazRepositoryDb implements CitatelskyPreukazRepository {
	@Autowired
	private CitatelskyPreukazRepositorySpring citatelskyPreukazRepositorySpring;

	@Override
	public void create(CitatelskyPreukaz citatelskyPreukaz) {
		citatelskyPreukazRepositorySpring.save(citatelskyPreukaz);
	}

	@Override
	public List<CitatelskyPreukaz> readAll() {
		List<CitatelskyPreukaz> result = new ArrayList<>();
		for (CitatelskyPreukaz citatelskyPreukaz : citatelskyPreukazRepositorySpring.findAll() ) {
			result.add(citatelskyPreukaz);
		}
		return result;
	}

}
