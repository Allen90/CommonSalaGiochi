package model;

import java.sql.Timestamp;
import java.util.Date;

import eccezioni.EccezioneUtente;

public class Utente {
	
	private static final long CREDITI_INIZIALI = 80;
	
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private long crediti;
	private long crediti_giornalieri;
	private Timestamp ultimaVisita;

	
	public Utente(String nome, String cognome, String username, String password, long crediti) throws EccezioneUtente {
		
		if(username != null && username != ""
				&& password != null && nome !=null && cognome != null) {
			this.username = username;
			this.password = password;
			this.nome = nome;
			this.cognome = cognome;
			
			if(crediti > 0)
				this.crediti = crediti;
			else this.crediti = getCreditiIniziali();
			
			this.ultimaVisita = new Timestamp(new Date().getTime());
			
			
		} else {
			throw new EccezioneUtente(String.format("Bad user/password passed '%s'/'%s'", this.username, this.password));
		}
	}
	
	public Utente(String username, String password) {
		this.username = username;
		this.password = password;
		this.crediti = getCreditiIniziali();
		this.ultimaVisita = new Timestamp(new Date().getTime());
	}
	
	public Utente(String username) {
		this.username = username;
		this.password = "";
		this.crediti = getCreditiIniziali();
		this.ultimaVisita = new Timestamp(new Date().getTime());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Timestamp getUltimaVisita() {
		return ultimaVisita;
	}

	public void setUltimaVisita(Timestamp ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}

	public long getCrediti_giornalieri() {
		return crediti_giornalieri;
	}

	public void setCrediti_giornalieri(long crediti_giornalieri) {
		this.crediti_giornalieri = crediti_giornalieri;
	}
	
	public void resetCrediti_giornalieri(){
		crediti_giornalieri = 0;
	}

	public long getCrediti() {
		return crediti;
	}

	public void setCrediti(long crediti) {
		this.crediti = crediti;
	}
	
	public long aggiungiCrediti(long credits) {
		
		if(credits > 0) {
			this.crediti = this.crediti + credits;
		}
		
		return this.crediti;
	}
	
	public long getCreditiIniziali() {
		return CREDITI_INIZIALI;
	}
	
//	@Override
//	public String toString() {
//		return String.format("Utente '%s'[%dc] - {'%s'} - Ultima visita %s", this.username, this.crediti, this.password, this.ultimaVisita.toString());
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Utente)) {
			return false;
		} else {
			if (((Utente) obj).getUsername() == this.username) {
				return true;
			} else {
				return false;
			}
		}
	}
}
