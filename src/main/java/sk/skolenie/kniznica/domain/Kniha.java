package sk.skolenie.kniznica.domain;

import java.io.Serializable;

public class Kniha implements Serializable {
	private static final long serialVersionUID = -6033178830063839523L;
	
	private Osoba autor;
	private String nazov;
	
	public Kniha(Osoba autor, String nazov) {
		this.autor = autor;
		this.nazov = nazov;
	}

	@Override
	public String toString() {
		return "Kniha [autor=" + autor + ", nazov=" + nazov + "]";
	}

	public String getNazov() {
		return nazov;
	}
	
	public Osoba getAutor() {
		return autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((nazov == null) ? 0 : nazov.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kniha other = (Kniha) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (nazov == null) {
			if (other.nazov != null)
				return false;
		} else if (!nazov.equals(other.nazov))
			return false;
		return true;
	}
	
}
