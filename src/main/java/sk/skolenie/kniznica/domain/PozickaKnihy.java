package sk.skolenie.kniznica.domain;

import java.time.LocalDate;

public class PozickaKnihy {

	private Kniha kniha;
	private CitatelskyPreukaz citatelskyPreukaz;
	private LocalDate odkedy;
	private LocalDate dokedy;
	
	public PozickaKnihy(Kniha kniha, CitatelskyPreukaz citatelskyPreukaz) {
		this.kniha = kniha;
		this.citatelskyPreukaz = citatelskyPreukaz;
		this.odkedy = LocalDate.now();
		this.dokedy = odkedy.plusMonths(1);
	}

	@Override
	public String toString() {
		return "PozickaKnihy [kniha=" + kniha + ", citatelskyPreukaz=" + citatelskyPreukaz + ", odkedy=" + odkedy
				+ ", dokedy=" + dokedy + "]";
	}

	public Kniha getKniha() {
		return kniha;
	}

	public CitatelskyPreukaz getCitatelskyPreukaz() {
		return citatelskyPreukaz;
	}
	
}
