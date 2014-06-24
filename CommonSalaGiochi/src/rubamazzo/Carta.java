package rubamazzo;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class Carta{
	final Seme seme;
	final Figura figura;

	private StringTokenizer st;	
	
	public Carta() {
		figura = Figura.COPERTA;
		seme = Seme.COPERTA;
	}
	
	public Carta(Figura f, Seme s) {
		figura = f;
		seme = s;
	}
	
	public Carta(String figura, String seme){
		this.figura = Figura.getFiguraDaString(figura);
		this.seme = Seme.getSemeDaString(seme);
	}

	public Carta (String s){
		st = new StringTokenizer(s, "#");
		this.figura = Figura.getFiguraDaString(st.nextToken());
		this.seme = Seme.getSemeDaString(st.nextToken());
		
	}
	
	@Override
	public String toString() {
		return String.format("%s#%s#", figura.nome,seme.nome);
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
