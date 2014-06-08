package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmiClient.ClientRMI;
import userModel.Utente;
import userModel.UtenteReg;
import eccezioni.EccezioneUtente;

public interface RmiServer extends Remote{
	public RmiTaskControl login(ClientRMI c, Utente u);
	public RmiTaskControl registra(ClientRMI c, UtenteReg u) throws EccezioneUtente, RemoteException;
}