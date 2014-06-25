package rubamazzo;

import java.util.ArrayList;
/**
 * rappresenta la singola mossa effettuata dalll'utente
 * @author fritz
 *
 */

public class Mossa {

	private int tipoMossa = 0;
	private Carta giocata = null;
	private ArrayList<Carta> carteBersaglio = null;
	int giocatoreBersaglio = -1;


	public Mossa(Carta giocata){
		tipoMossa = 0;
		this.giocata = giocata;
	}

	public Mossa(Carta giocata, Carta bersaglio){
		tipoMossa = 1;
		this.giocata = giocata;
		carteBersaglio = new ArrayList<>();
		carteBersaglio.add(bersaglio);	
	}

	public Mossa(Carta giocata, ArrayList<Carta> bersaglio){
		tipoMossa = 2;
		this.giocata = giocata;
		carteBersaglio = bersaglio;	
	}

	public Mossa(Carta giocata, int bersaglio){
		tipoMossa = 3;
		this.giocata = giocata;
		giocatoreBersaglio = bersaglio;
	}


	public int getTipoMossa(){
		return tipoMossa;
	}

	public Carta getCartaBersaglio(){
		return carteBersaglio.get(0);
	}

	public Carta getCartaGiocata(){
		return giocata;
	}

	public ArrayList<Carta> getCarteBersaglio(){
		return carteBersaglio;
	}

	public int getGiocatoreBersaglio(){
		return giocatoreBersaglio;
	}

	public Mossa(int tipo, Carta giocata){
		tipoMossa = tipo;
		this.giocata = giocata;
	}


}
