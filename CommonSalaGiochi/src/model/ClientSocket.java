package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Client{
	private Socket client;
	private PrintWriter writer = null;
	private BufferedReader reader = null;
	private int id;
	public ClientSocket(Socket client,int id){
		this.id = id;
		this.client = client;

	}
	@Override
	public Boolean rolla() {
		String stringa = "exit";
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//Aspertto che il client scriva qualcosa sul socket
			while(!reader.ready()){
				Thread.sleep(500);
			}
			//Effettuo la lettura bloccante
			stringa = reader.readLine();
			System.out.println("Ricevuta stringa: "+stringa);
			stringa = "Ciao "+stringa;
		} catch (IOException e) {
			System.err.println("Errore di comunicazione.");
		} catch (InterruptedException e) {
			System.err.println("Ricevuto Interrupt");
		} finally {
			try { reader.close(); } catch (IOException e) {e.printStackTrace();}
			if(!client.isClosed()){
				try {client.close(); } catch (IOException e) {e.printStackTrace();}
			}
		}
		if(stringa == "rolla")
			return true;
		else return false;
	}

	@Override
	public void hoVinto() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mossa() {
		// TODO Auto-generated method stub

	}

	public int getUser(){
		return id;
	}
	
	public void invio(String s){
		try {
			writer = new PrintWriter(client.getOutputStream(), true);
			writer.write(s);
			writer.flush();
		} catch (IOException e) {
			System.err.println("Errore di comunicazione.");
		} finally {
			writer.close();
			if(!client.isClosed()){
				try {client.close(); } catch (IOException e) {e.printStackTrace();}
			}
		}
	}

}
