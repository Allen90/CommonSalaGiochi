package rubamazzo;

import java.util.ArrayList;

import eccezioni.EccezioneRubamazzo;

public class TavoloRubamazzo {

	private ArrayList<Carta> banco = null;
	private ArrayList<GiocatoreRubamazzo> giocatori = null;
	private Mazzo mazzo = null;
	private boolean finePartita;
	
	public ArrayList<GiocatoreRubamazzo> getGiocatori(){
		return giocatori;
	}
	
	public boolean isFinita(){
		return finePartita;
	}
	
	public TavoloRubamazzo(ArrayList<GiocatoreRubamazzo> giocatori){
		finePartita = false;
		mazzo = Mazzo.nuovo();
		mazzo.mescola();
		this.giocatori = giocatori;
		daiCarteInizio(this.giocatori);
		banco = new ArrayList<Carta>();
		riempiBanco();
	}
	
	private boolean mazzoVuoto(){
		if(mazzo.vuoto()) return true;
		else return false;
	}
	
	public void riempiBanco(){
		banco.addAll(mazzo.pesca(4));
		finePartita = mazzoVuoto();
	}
	
	public void daiCarteInizio(ArrayList<GiocatoreRubamazzo> giocatori){
		for(GiocatoreRubamazzo g: giocatori){
			g.pesca(mazzo, 3);
		}
		finePartita = mazzoVuoto();
	}
	
	public void daiCarte(ArrayList<GiocatoreRubamazzo> giocatori){
		for(GiocatoreRubamazzo g: giocatori){
			g.pesca(mazzo);
		}
		finePartita = mazzoVuoto();
	}
	
	private boolean controllaMossa(Carta giocata, Carta inBanco){
		if(giocata.confronta(inBanco)) return true;
		else return false;
	}

	private boolean controllaMossa(Carta giocata, ArrayList<Carta> inBanco){
		if(giocata.confronta(inBanco))	return true;
		else return false;
	}
	
	private boolean controllaMossa(Carta giocata, GiocatoreRubamazzo bersaglio){
		boolean ok;
		try{
			if(bersaglio.getPrimaBottino().confronta(giocata))
				ok = true;
			else
				ok = false;
		}catch(EccezioneRubamazzo e){
			ok = false;
		}
		return ok;		
	}
	
	public void daGiocatoreABanco(Carta giocata, int giocante){
		giocatori.get(giocante).giocaCarta(giocata);
		banco.add(giocata);
		if(giocata.figura.valore == 1){
			giocatori.get(giocante).aggiungiBottino(banco);
			banco.removeAll(banco);
		}
	}
	
	public void daBancoAGiocatore(Carta giocata, Carta inBanco, int giocante) throws EccezioneRubamazzo{
		ArrayList<Carta> bottino = null;
		if(!controllaMossa(giocata, inBanco)) 
			throw new EccezioneRubamazzo("Mossa non legale!");	
		else{
			giocatori.get(giocante).giocaCarta(giocata);
			bottino = new ArrayList<Carta>();
			bottino.add(giocata);
			bottino.add(inBanco);
			banco.remove(inBanco);
			giocatori.get(giocante).aggiungiBottino(bottino);
		}
	}
	
	public void daBancoAGiocatore(Carta giocata, ArrayList<Carta> inBanco, int giocante) throws EccezioneRubamazzo{
		ArrayList<Carta> bottino = null;
		if(!controllaMossa(giocata, inBanco)) 
			throw new EccezioneRubamazzo("Mossa non legale!");	
		else{
			giocatori.get(giocante).giocaCarta(giocata);
			bottino = new ArrayList<Carta>();
			bottino.add(giocata);
			bottino.addAll(inBanco);
			banco.removeAll(inBanco);
			giocatori.get(giocante).aggiungiBottino(bottino);
		}
	}
	
	public void daGiocatoreAGiocatore(int giocante, Carta giocata, GiocatoreRubamazzo bersaglio) throws EccezioneRubamazzo{
		ArrayList<Carta> bottino = null;
		if(!controllaMossa(giocata, bersaglio))
			throw new EccezioneRubamazzo("Mossa non legale!");	
		else{
			giocatori.get(giocante).giocaCarta(giocata);
			bottino = new ArrayList<Carta>();
			bottino.add(giocata);
			bottino.addAll(bersaglio.getBottino());
			bersaglio.azzeraBottino();
			giocatori.get(giocante).aggiungiBottino(bottino);
		}
	}
}
