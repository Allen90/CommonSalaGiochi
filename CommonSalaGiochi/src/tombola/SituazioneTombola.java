package tombola;

import java.util.ArrayList;

public class SituazioneTombola {

	private int numeroPartita = -1;
	private ArrayList<Tabella> cartelle = null;
	private Tabellone tabellone = null;
	private String username = null;
	private boolean[] premiDisponibili;

	
	
	public SituazioneTombola (Tabellone tabellone, GiocatoreTombola giocatore, boolean[] premiDisponibili, int numeroPartita){
		cartelle = giocatore.getCartelle();
		this.tabellone = tabellone;
		username = new String(giocatore.getUtente().getUsername());
		this.premiDisponibili = premiDisponibili;
		this.numeroPartita = numeroPartita;
	}
	
	public SituazioneTombola (Tabellone tabellone, String username, ArrayList<Tabella> cartelle, boolean[] premiDisponibili, int numeroPartita){
		this.cartelle = cartelle;
		this.tabellone = tabellone;
		this.username = username;
		this.premiDisponibili = premiDisponibili;
		this.numeroPartita = numeroPartita;
	}

	public void aggiornaSituazione(Tabellone tabellone, GiocatoreTombola giocatore, boolean[] premiDisponibili){
		cartelle = giocatore.getCartelle();
		this.tabellone = tabellone;
		username = new String(giocatore.getUtente().getUsername());
		this.premiDisponibili = premiDisponibili;
	}
	
	
	
	public int getNumeroPartita() {
		return numeroPartita;
	}
	
	public Tabella getTabella(int i){
		return cartelle.get(i);
	}
	
	public ArrayList<Tabella> getTabelle(){
		return cartelle;
	}
	
	public int getUltimoEstratto(){
		return tabellone.getUltimoEstratto();
	}
	
	public String getUsername(){
		return username;
	}
	
	public Tabellone getTabellone(){
		return tabellone;
	}

	public boolean[] getPremiDisponibili() {
		return premiDisponibili;
	}
	
	
}
