package rubamazzo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * classe utilizzata per rappresentare la singola carta
 * @author fritz
 *
 */

public class Carta implements Serializable{
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

	/**
	 * costruttore utlizzato dal decoder per ricostruire la carta da una stringa passata
	 * @param s
	 */
	public Carta (String s){
		st = new StringTokenizer(s, "#");
		this.figura = Figura.getFiguraDaString(st.nextToken());
		this.seme = Seme.getSemeDaString(st.nextToken());
		
	}
	/**
	 * metodo utilizzato dall'encoder per codifica in stringa 
	 * utilizzando la specifica data
	 */
	@Override
	public String toString() {
		return String.format("%s#%s#", figura.nome,seme.nome);
	}
	
	/**
	 * metodo utlizzato per confrontare la singola carta con altre carte simili
	 * per poter prendere dalla mano una carta del banco con la stessa figura 
	 * @param c
	 * @return
	 */
	
	public boolean confronta(Carta c){
		return figura == c.figura;
	}
	
	public boolean confronta(ArrayList<Carta> carte){
		int somma = 0;
		for(Carta c: carte)
			somma += c.figura.valore;
		return figura.valore == somma;
	}
	/**
	 * metodo per identificare la carta all'interno di una collezione
	 * @param c
	 * @return
	 */
	public boolean confrontaCarta(Carta c){
		return (c.seme == seme && c.figura == figura);
	}
}
