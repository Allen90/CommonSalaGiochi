package rubamazzo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;



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

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder()
//		.append("Mazzo di ").append(carte.size()).append(" carte:\n");
//		for (Carta c : carte) sb.append(c).append("\n");
//		return sb.toString();
//	}

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
		if(carte.isEmpty()) return true;
		else return false;
	}
}