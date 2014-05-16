package model;

import java.sql.Timestamp;
import java.util.Date;

import eccezioni.EccezioneUtente;

public class Utente {
	
	private static final long CREDITI_INIZIALI = 80;
	
	private String username;
	private String password;
	private long crediti;
	private Timestamp ultimaVisita;
	
	public Utente(String username, String password, long credits) throws EccezioneUtente {
		
		if(username != null && username != ""
				&& password != null ) {
			this.username = username;
			this.password = password;
			this.ultimaVisita = new Timestamp(new Date().getTime());
			
			if (credits > 0) {
				this.crediti = credits;
			} else {
				this.crediti = getCreditiIniziali();
			}
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

	public long getCredits() {
		return crediti;
	}

	public void setCredits(long credits) {
		this.crediti = credits;
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
	
	@Override
	public String toString() {
		return String.format("Utente '%s'[%dc] - {'%s'} - Ultima visita %s", this.username, this.crediti, this.password, this.ultimaVisita.toString());
	}
	
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
