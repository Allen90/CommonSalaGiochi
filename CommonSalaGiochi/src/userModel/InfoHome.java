package userModel;

import java.io.Serializable;
import java.util.Date;

public class InfoHome implements Serializable{
	
	private String nome;
	private String cognome;
	private int crediti;
	private int posizione;
	private Date ultimoLogin;
	
	public InfoHome(String nome, String cognome, int crediti, int posizione,Date ultimoLogin){
		this.nome = nome;
		this.cognome = cognome;
		this.crediti = crediti;
		this.posizione = posizione;
		this.ultimoLogin = ultimoLogin;
	}
	
	public int getPosizione(){
		return posizione;
	}
	
	public int getCrediti(){
		return crediti;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
}
