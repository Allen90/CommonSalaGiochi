package rubamazzo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

class Mazzo {
	
	private LinkedList<Carta> carte = null;
	
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

	public Carta pesca() {
		if (carte.isEmpty())
			throw new IllegalStateException("Mazzo vuoto");
		return carte.removeFirst();
	}

	public ArrayList<Carta> pesca(int n) {
		if (n > carte.size()) {
			String msg = String.format("Chieste %d carte da un mazzo di %d", n, carte.size());
			throw new IllegalArgumentException(msg);
		}
		ArrayList<Carta> pescate = new ArrayList<Carta>();
		for (int i=0; i<n; i++)
			pescate.add(carte.removeFirst());
		return pescate;
	}
	
	public boolean vuoto(){
		return carte.isEmpty();
	}
}