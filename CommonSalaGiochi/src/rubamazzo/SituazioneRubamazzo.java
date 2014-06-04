package rubamazzo;

import java.util.ArrayList;

import eccezioni.EccezioneRubamazzo;

public class SituazioneRubamazzo {

	private ArrayList<Carta> mano = null;
	private ArrayList<Carta> bottini = null;
	private String username = null;
	
	public SituazioneRubamazzo(TavoloRubamazzo tavolo, GiocatoreRubamazzo g){
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
}
