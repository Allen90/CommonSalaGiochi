package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmiClient.ClientRmi;
import userModel.Utente;
import userModel.UtenteReg;
import eccezioni.EccezioneUtente;

public interface RmiServer extends Remote{
	public RmiTaskControl login(ClientRmi c, Utente u) throws RemoteException;
	public RmiTaskControl registra(ClientRmi c, UtenteReg u) throws EccezioneUtente, RemoteException;
}