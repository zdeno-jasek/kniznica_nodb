package sk.skolenie.kniznica.domain;

import java.util.List;

public interface CitatelskyPreukazRepository {

	void create( CitatelskyPreukaz citatelskyPreukaz );
	List<CitatelskyPreukaz> readAll();
}
