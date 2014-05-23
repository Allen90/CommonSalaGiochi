package model;

import java.util.Collections;
import java.util.LinkedList;

class Mazzo {
	
	private LinkedList<Carta> carte;
	
	private Mazzo() {
		carte = new LinkedList<>();
		for (Seme s: Seme.values())
			for (Figura f: Figura.values())
				carte.add(new Carta(f, s));
	}
	
	static Mazzo nuovo() {
		return new Mazzo();
	}

	void mescola() {
		Collections.shuffle(carte);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder()
		.append("Mazzo di ").append(carte.size()).append(" carte:\n");
		for (Carta c : carte) sb.append(c).append("\n");
		return sb.toString();
	}

	public Carta pesca() {
		if (carte.isEmpty())
			throw new IllegalStateException("Mazzo vuoto");
		return carte.removeFirst();
	}

	public Carta[] pesca(int n) {
		if (n > carte.size()) {
			String msg = String.format("Chieste %d carte da un mazzo di %d", n, carte.size());
			throw new IllegalArgumentException(msg);
		}
		Carta[] arr = new Carta[n];
		for (int i=0; i<n; i++) arr[i] = carte.removeFirst();
		return arr;
	}
}