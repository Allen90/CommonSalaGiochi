package rubamazzo;

import java.util.ArrayList;

import userModel.Utente;
import eccezioni.EccezioneRubamazzo;


/**
 * classe utilizzata per rappresentare un singolo giocatore di una partita rubamazzo
 * all'interno contiene i metodi necessari per giocare la propria mano e per l'eventuale furto di
 * un bottino avversario
 * @author fritz
 *
 */
public class GiocatoreRubamazzo {

	private ArrayList<Carta> bottino = null;
	private ArrayList<Carta> mano = null;
	private Utente utente = null;
	
	public GiocatoreRubamazzo(Utente u){
		utente = u;
		bottino = new ArrayList<Carta>();
		bottino.add(new Carta());
		mano = new ArrayList<Carta>();
	}
	
	public ArrayList<Carta> getMano() {
		return mano;
	}

	public Utente getUtente() {
		return utente;
	}

	public Carta getPrimaBottino() throws EccezioneRubamazzo{
		try{
			return bottino.get(bottino.size()-1);
		}catch(IndexOutOfBoundsException e){
			throw new EccezioneRubamazzo("Il giocatore non ha bottino!");
		}
	}
	
	public ArrayList<Carta> rubaBottino() throws EccezioneRubamazzo{
		if(bottino.get(0).confrontaCarta(new Carta()))
			throw new EccezioneRubamazzo("Il giocatore non ha bottino!");
		else{
			bottino.remove(0);
			return bottino;
		}
	}
	
	public ArrayList<Carta> getBottino() throws EccezioneRubamazzo{
		
		if(getPrimaBottino().confrontaCarta(new Carta()))
			throw new EccezioneRubamazzo("Il giocatore non ha bottino!");
		else{
			return bottino;
		}
	}
	
	/**
	 * mette una carta nulla alla fine del bottino
	 * in modo che il bottino non sia mai vuoto
	 */
	private void fondoBottino(){
		bottino.add(0, new Carta());
	}
	
	public boolean giocaCarta(Carta giocata){
		for(Carta c : mano)
			if(giocata.confrontaCarta(c))
				return mano.remove(c); 
		return false;
		
	}
	
	public void aggiungiBottino(ArrayList<Carta> nuovoBottino){
		bottino.addAll(nuovoBottino);
	}
	
	public void aggiungiBottino(Carta nuovoBottino){
		bottino.add(nuovoBottino);
	}
	
	public void azzeraBottino(){
		int k = bottino.size();
		for(int j = k-1; j >= 0; j--){
			bottino.remove(j);
		}
		fondoBottino();
	}
	
	public void pesca(Mazzo m) {
		mano.add(m.pesca());
	}

	public void pesca(Mazzo m, int n) {
		mano.addAll(m.pesca(n));
	}
	
}
