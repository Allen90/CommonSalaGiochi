package rubamazzo;

import java.util.ArrayList;


public class Carta{
	final Seme seme;
	final Figura figura;

	public Carta(Figura f, Seme s) {
		figura = f;
		seme = s;
	}
	
	public Carta(String figura, String seme){
		this.figura = Figura.valueOf(figura);
		this.seme = Seme.valueOf(seme);
	}

	@Override
	public String toString() {
		return String.format("%s#%s", seme.nome, figura.nome);
	}
	
	public boolean confronta(Carta c){
		return figura == c.figura;
	}
	
	public boolean confronta(ArrayList<Carta> carte){
		int somma = 0;
		for(Carta c: carte)
			somma += c.figura.valore;
		return figura.valore == somma;
	}
	
	public boolean confrontaCarta(Carta c){
		return (c.seme == seme && c.figura == figura);
	}
}
