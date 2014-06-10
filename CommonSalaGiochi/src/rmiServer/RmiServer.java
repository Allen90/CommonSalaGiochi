package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmiClient.ClientRmi;
import eccezioni.EccezioneUtente;

public interface RmiServer extends Remote{
	public RmiTaskControl login(ClientRmi c, String username,String password) throws RemoteException, EccezioneUtente;
	public RmiTaskControl registra(ClientRmi c, String username, String password, String confPassword, String nome, String cognome) throws EccezioneUtente, RemoteException;
}