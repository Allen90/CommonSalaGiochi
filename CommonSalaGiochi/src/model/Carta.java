package model;

public class Carta implements Comparable<Carta> {
	final Seme seme;
	final Figura figura;

	public Carta(Figura f, Seme s) {
		figura = f;
		seme = s;
	}

	@Override
	public String toString() {
		return String.format("%s[%s]", seme.nome, figura.nome);
	}

	@Override
	public int compareTo(Carta c) {
		int diff = seme.valore - c.seme.valore;
		if (diff != 0) return diff;
		return figura.valore - c.figura.valore;
	}

	public boolean gt(Carta c) {
		return this.compareTo(c) >= 1;
	}
}
