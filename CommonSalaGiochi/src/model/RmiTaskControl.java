package model;

import java.rmi.Remote;
import java.util.ArrayList;

import rubamazzo.SituazioneRubamazzo;
import rubamazzo.TavoloRubamazzo;
import slot.Rollata;
import tombola.GiocatoreTombola;
import tombola.SituazioneTombola;

public interface RmiTaskControl extends Remote{
	public Rollata rolla();
	public SituazioneTombola aggTombola();
	public SituazioneRubamazzo aggRubaMazzo();
	public ArrayList<Utente> aggClass();
	public ArrayList<Utente> aggClassGiorn();
	public void termina();
	}
