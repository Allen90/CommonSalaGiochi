package model;

import java.rmi.Remote;
import java.util.ArrayList;

import rubamazzo.Tavolo;

public interface RmiTaskControl extends Remote{
	public Rollata rolla();
	public GiocatoreTombola aggTombola();
	public Tavolo aggRubaMazzo();
	public ArrayList<Utente> aggClass();
	public ArrayList<Utente> aggClassGiorn();
	public void termina();
	}
