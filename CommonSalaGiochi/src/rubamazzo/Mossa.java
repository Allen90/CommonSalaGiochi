package rubamazzo;

import java.util.ArrayList;

public class Mossa {

	private int tipoMossa = 0;
	private String username = null;
	private Carta giocata = null;
	private ArrayList<Carta> carteBersaglio = null;
	int giocatoreBersaglio = -1;
	
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
	
	public Mossa(int tipo, String username, Carta giocata){
		tipoMossa = tipo;
		this.username = username;
		this.giocata = giocata;
	}
	
	public Mossa(int tipo, String username, Carta giocata, Carta bersaglio){
		tipoMossa = tipo;
		this.username = username;
		this.giocata = giocata;
		carteBersaglio = new ArrayList<>();
		carteBersaglio.add(bersaglio);	
	}
	
	public Mossa(int tipo, String username, Carta giocata, ArrayList<Carta> bersaglio){
		tipoMossa = tipo;
		this.username = username;
		this.giocata = giocata;
		carteBersaglio = bersaglio;	
	}
	
	public Mossa(int tipo, String username, Carta giocata, int bersaglio){
		tipoMossa = tipo;
		this.username = username;
		this.giocata = giocata;
		giocatoreBersaglio = bersaglio;
	}
}
