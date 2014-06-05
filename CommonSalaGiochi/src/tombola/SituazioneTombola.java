package tombola;

import java.util.ArrayList;

public class SituazioneTombola {

	private ArrayList<Tabella> cartelle = null;
	private Tabellone tabellone = null;
	private String username = null;
	
	public SituazioneTombola (Tabellone tabellone, GiocatoreTombola giocatore){
		cartelle = giocatore.getCartelle();
		this.tabellone = tabellone;
		username = new String(giocatore.getUtente().getUsername());
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
}
