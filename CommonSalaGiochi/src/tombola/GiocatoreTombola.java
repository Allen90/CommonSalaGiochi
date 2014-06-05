package tombola;

import java.util.ArrayList;

import model.Utente;



public class GiocatoreTombola {
	
	private ArrayList<Tabella> cartelle = null;
	private Utente utente = null;
	private Tabellone tabellone = null;
	
	public GiocatoreTombola(ArrayList<Tabella> cartelle, Utente giocatore ){
		this.utente = giocatore;
		this.cartelle = new ArrayList<Tabella>(cartelle);
	}
	
	public int getNCartelle(){
		return cartelle.size();
	}
	
	public void controllaEstratto(int estratto, int indice){
		cartelle.get(indice).controllaEstratto(estratto);
	}
	
	public Utente getUtente(){
		return utente;
	}
	
	public ArrayList<Tabella> getCartelle(){
		return cartelle;
	}
}
