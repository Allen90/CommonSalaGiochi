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
	public int compareTo(Carta other) {
		int diff = seme.valore - other.seme.valore;
		if (diff != 0) return diff;
		return figura.valore - other.figura.valore;
	}

	public boolean gt(Carta other) {
		return this.compareTo(other) >= 1;
	}
}
