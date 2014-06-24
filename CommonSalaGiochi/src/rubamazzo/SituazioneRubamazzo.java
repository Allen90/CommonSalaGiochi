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
	private int mioIndice = -1;
	private String username = null;
	boolean abilitato = false;
	String ultimaMossa = "";

	public SituazioneRubamazzo(TavoloRubamazzo tavolo, GiocatoreRubamazzo g, int n){
		username = new String(g.getUtente().getUsername());
		mano = new ArrayList<>();
		mano.addAll(g.getMano());
		username = new String(g.getUtente().getUsername());
		bottini = new ArrayList<>();
		banco = new ArrayList<>();
		for(GiocatoreRubamazzo i: tavolo.getGiocatori())
			try {
				bottini.add(i.getPrimaBottino());
			} catch (EccezioneRubamazzo e) {
			}
		try {
			banco = tavolo.getBanco();
		} catch (EccezioneRubamazzo e) {
			banco = null;
		}
		for(int i = 0; i < tavolo.getGiocatori().size(); i++)
			if(tavolo.getGiocatori().get(i).getUtente().getUsername().equals(g.getUtente().getUsername()))
				mioIndice = i;
		numeroPartita = n;
	}

	public SituazioneRubamazzo(String username, int mioIndice, ArrayList<Carta> mano, ArrayList<Carta> bottini, ArrayList<Carta> banco, int n, boolean abilitato/*, String ultimaMossa*/){
		this.mano = mano;
		this.username = username;
		this.banco = banco;
		this.bottini = bottini;
		this.mano = mano;
		numeroPartita = n;
		this.abilitato = abilitato;
		this.mioIndice = mioIndice;
		//		this.ultimaMossa = ultimaMossa;
	}


	public void aggiornaSituazione(GiocatoreRubamazzo g,TavoloRubamazzo t/*, Mossa ultimaMossa*/){
		for(int i = 0; i< t.getGiocatori().size(); i++)
			if(t.getGiocatori().get(i).getUtente().getUsername().equals(g.getUtente().getUsername()))
				mano = t.getGiocatori().get(i).getMano();
		for(GiocatoreRubamazzo i: t.getGiocatori())
			try {
				bottini.removeAll(bottini);
				bottini.add(i.getPrimaBottino());
			} catch (EccezioneRubamazzo e) {
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

	public int getMioIndice() {
		return mioIndice;
	}
	
	public ArrayList<Carta> getBottiniAltrui(){
		ArrayList<Carta> temp = new ArrayList<>(bottini);
		if(getMioBottino() != null && getMioBottino() != null)
			temp.remove(getMioBottino());
		
		return temp;
	}

	public Carta getMioBottino(){
		if(mioIndice != -1 && bottini.size() > 0)
			return bottini.get(mioIndice);
		else
			return null;
	}

	public ArrayList<Carta> getBanco(){
		return banco;
	}
}
