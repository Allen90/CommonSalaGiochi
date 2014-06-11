package rmiServer;

import java.rmi.Remote;
import java.util.ArrayList;

import eccezioni.EccezioneClassificaVuota;
import eccezioni.EccezioneUtente;
import rubamazzo.Mossa;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import userModel.InfoHome;
import userModel.Utente;

public interface RmiTaskControl extends Remote{
	public Rollata rolla();
	public SituazioneTombola aggTombola();
	public SituazioneRubamazzo aggRubaMazzo();
	public ArrayList<Utente> aggClass() throws EccezioneClassificaVuota;
	public ArrayList<Utente> aggClassGiorn() throws EccezioneClassificaVuota;
	public boolean vintoTombola(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga);
	public boolean mossaRubamazzo(Mossa m,int numPartita);
	public void termina();
	public boolean giocoTombola(int numCartelle) throws EccezioneUtente;
	public boolean giocoRubamazzo() throws EccezioneUtente;
	public InfoHome getInfoHome();
}
