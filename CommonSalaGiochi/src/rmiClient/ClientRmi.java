package rmiClient;

import java.rmi.*;

public interface ClientRmi extends Remote{
	public void callBack() throws RemoteException;
}