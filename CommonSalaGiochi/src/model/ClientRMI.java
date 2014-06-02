package model;

import java.rmi.*;

public interface ClientRMI extends Remote{
	public void callBack() throws RemoteException;
}