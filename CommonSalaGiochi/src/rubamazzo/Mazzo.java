package rubamazzo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

/**
 * classe utilizzata per rappresentare un mazzo di carte
 * permette l'estrazione di una singola carta da esso
 * @author fritz
 *
 */
class Mazzo implements Serializable{
	
	private LinkedList<Carta> carte = null;
	
	private Mazzo() {
		carte = new LinkedList<>();
		for (Seme s: Seme.values())
			for (Figura f: Figura.values())
				if(!f.nome.equals("RETRO") && !s.nome.equals("VERT"))
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