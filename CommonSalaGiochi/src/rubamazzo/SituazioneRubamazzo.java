package rubamazzo;

import java.util.ArrayList;

import eccezioni.EccezioneRubamazzo;

public class SituazioneRubamazzo {

	private int numeroPartita = 0;
	private ArrayList<Carta> mano = null;
	private ArrayList<Carta> bottini = null;
	private ArrayList<Carta> banco = null;
	private String username = null;
	boolean abilitato = false;
	
	public SituazioneRubamazzo(TavoloRubamazzo tavolo, GiocatoreRubamazzo g, int n){
		mano = new ArrayList<>();
		mano.addAll(g.getMano());
		username = new String(g.getUtente().getUsername());
		for(GiocatoreRubamazzo i: tavolo.getGiocatori())
			try {
				bottini.add(i.getPrimaBottino());
			} catch (EccezioneRubamazzo e) {
				Carta c = null;
				bottini.add(c);
			}
		try {
			banco = tavolo.getBanco();
		} catch (EccezioneRubamazzo e) {
			banco = null;
		}
		numeroPartita = n;
	}

	public SituazioneRubamazzo(String username, ArrayList<Carta> mano, ArrayList<Carta> bottini, ArrayList<Carta> banco, int n, boolean abilitato){
		this.mano = mano;
		this.username = username;
		this.banco = banco;
		this.bottini = bottini;
		this.mano = mano;
		numeroPartita = n;
		this.abilitato = abilitato;
	}

	
	public void aggiornaSituazione(GiocatoreRubamazzo g,TavoloRubamazzo t){
		mano = g.getMano();
		for(GiocatoreRubamazzo i: t.getGiocatori())
			try {
				bottini.add(i.getPrimaBottino());
			} catch (EccezioneRubamazzo e) {
				Carta c = null;
				bottini.add(c);
			}
	}
	
	public int getPartita(){
		return numeroPartita;
	}
	
	public void setAbilitato(boolean b){
		abilitato = b;
	}
	
	public boolean getAbilitato(){
		return abilitato;
	}
	
	public String getUsername(){
		return username;
	}
	
	public ArrayList<Carta> getMano(){
		return mano;
	}
	
	public ArrayList<Carta> getBottini(){
		return bottini;
	}
	
	public ArrayList<Carta> getBanco(){
		return banco;
	}
}
