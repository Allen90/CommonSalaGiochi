package rubamazzo;

import java.util.ArrayList;

import model.Utente;
import eccezioni.EccezioneRubamazzo;

public class GiocatoreRubamazzo {

	private ArrayList<Carta> bottino = null;
	private ArrayList<Carta> mano = null;
	private Utente utente = null;
	
	public GiocatoreRubamazzo(Utente u){
		utente = u;
		bottino = new ArrayList<Carta>();
		mano = new ArrayList<Carta>();
	}
	
	public ArrayList<Carta> getMano() {
		return mano;
	}

	public Utente getUtente() {
		return utente;
	}

	public Carta getPrimaBottino() throws EccezioneRubamazzo{
		if(bottino.get(0) == null) throw new EccezioneRubamazzo("Il giocatore non ha bottino!");
		else return bottino.get(0);
	}
	
	public ArrayList<Carta> getBottino() throws EccezioneRubamazzo{
		if(bottino.get(0) == null) throw new EccezioneRubamazzo("Il giocatore non ha bottino!");
		else return bottino;
	}
	
	public boolean giocaCarta(Carta giocata){
		for(Carta c : mano)
			if(giocata.confrontaCarta(c))
				return mano.remove(c); 
		return false;
		
	}
	
	public void aggiungiBottino(ArrayList<Carta> nuovoBottino){
		bottino.addAll(0,nuovoBottino);
	}
	
	
	
	public void pesca(Mazzo m) {
		mano.add(m.pesca());
	}

	public void pesca(Mazzo m, int n) {
		mano.addAll(m.pesca(n));
	}
	
}
