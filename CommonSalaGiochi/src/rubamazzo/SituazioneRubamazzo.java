package rubamazzo;

import java.io.Serializable;
import java.util.ArrayList;

import eccezioni.EccezioneRubamazzo;

public class SituazioneRubamazzo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int numeroPartita = 0;
	private ArrayList<Carta> mano = null;
	private ArrayList<Carta> bottini = null;
	private ArrayList<Carta> banco = null;
	private int mioBottino = -1;
	private String username = null;
	boolean abilitato = false;
	String ultimaMossa = "";

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
		try {
			for(int i = 0; i < bottini.size(); i++)
				if(bottini.get(i).confrontaCarta(g.getPrimaBottino()))
					mioBottino = i;
		} catch (EccezioneRubamazzo e) {
			mioBottino = -1;
		}
		numeroPartita = n;
	}

	public SituazioneRubamazzo(String username, ArrayList<Carta> mano, ArrayList<Carta> bottini, ArrayList<Carta> banco, int n, boolean abilitato/*, String ultimaMossa*/){
		this.mano = mano;
		this.username = username;
		this.banco = banco;
		this.bottini = bottini;
		this.mano = mano;
		numeroPartita = n;
		this.abilitato = abilitato;
		//		this.ultimaMossa = ultimaMossa;
	}


	public void aggiornaSituazione(GiocatoreRubamazzo g,TavoloRubamazzo t/*, Mossa ultimaMossa*/){
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
	
	public ArrayList<Carta> getBottiniAltrui(){
		ArrayList<Carta> temp = new ArrayList<>();
		temp.addAll(bottini);
		if(getMioBottino() != null)
			temp.remove(getMioBottino());
		return temp;
	}

	public Carta getMioBottino(){
		if(mioBottino != -1)
			return bottini.get(mioBottino);
		else
			return null;
	}

	public ArrayList<Carta> getBanco(){
		return banco;
	}
}
