package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import eccezioni.EccezioneClassificaVuota;
import eccezioni.EccezioneUtente;
import rubamazzo.Mossa;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import userModel.EntryClassifica;
import userModel.InfoHome;
import userModel.Utente;

public interface RmiTaskControl extends Remote{
	public Rollata rolla() throws RemoteException, EccezioneUtente;
	public SituazioneTombola aggTombola()  throws RemoteException;
	public SituazioneRubamazzo aggRubaMazzo()  throws RemoteException;
	public ArrayList<EntryClassifica> aggClass() throws EccezioneClassificaVuota, RemoteException;  
	public ArrayList<EntryClassifica> aggClassGiorn() throws EccezioneClassificaVuota, RemoteException;
	public boolean vintoTombola(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga) throws EccezioneUtente, RemoteException;
	public boolean mossaRubamazzo(Mossa m,int numPartita) throws RemoteException;
	public boolean giocoTombola(int numCartelle) throws EccezioneUtente, RemoteException;
	public boolean giocoRubamazzo() throws EccezioneUtente, RemoteException;
	public InfoHome getInfoHome() throws EccezioneUtente, RemoteException;
	public boolean logout() throws EccezioneUtente, RemoteException;
}
