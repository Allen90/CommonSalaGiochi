package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import eccezioni.EccezioneUtente;

/**
 * interfaccia del server rmi, che definisce i metodi di login e registrazione
 * @author fritz
 *
 */

public interface RmiServer extends Remote{
	public RmiTaskControl login(String username,String password) throws RemoteException, EccezioneUtente;
	public RmiTaskControl registra(String username, String password, String confPassword, String nome, String cognome) throws EccezioneUtente, RemoteException, ParseException;
}