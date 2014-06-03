package rubamazzo;

import java.util.ArrayList;


public class Carta{
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
	
	public boolean confronta(Carta c){
		if(figura == c.figura) return true;
		else return false;
	}
	
	public boolean confronta(ArrayList<Carta> carta){
		int somma = 0;
		for(Carta c: carta)
			somma += c.figura.valore;
		if(figura.valore == somma)	return true;
		else return false;
	}
	
	public boolean confrontaCarta(Carta c){
		if(c.seme == seme && c.figura == figura)
			return true;
		else return false;
	}
}
