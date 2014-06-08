package rmiServer;

import java.rmi.Remote;
import java.util.ArrayList;

import eccezioni.EccezioneClassificaVuota;
import rubamazzo.SituazioneRubamazzo;
import rubamazzo.TavoloRubamazzo;
import slot.Rollata;
import tombola.GiocatoreTombola;
import tombola.SituazioneTombola;
import userModel.Utente;

public interface RmiTaskControl extends Remote{
	public Rollata rolla();
	public SituazioneTombola aggTombola();
	public SituazioneRubamazzo aggRubaMazzo();
	public ArrayList<Utente> aggClass() throws EccezioneClassificaVuota;
	public ArrayList<Utente> aggClassGiorn() throws EccezioneClassificaVuota;
	public void termina();
	}
