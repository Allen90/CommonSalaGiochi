package model;

import java.rmi.Remote;
import java.util.ArrayList;

import rubamazzo.TavoloRubamazzo;
import slot.Rollata;
import tombola.GiocatoreTombola;

public interface RmiTaskControl extends Remote{
	public Rollata rolla();
	public GiocatoreTombola aggTombola();
	public TavoloRubamazzo aggRubaMazzo();
	public ArrayList<Utente> aggClass();
	public ArrayList<Utente> aggClassGiorn();
	public void termina();
	}
