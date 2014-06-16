package userModel;

import java.util.Date;

import eccezioni.EccezioneUtente;

public class Utente {
	
	private static final int CREDITI_INIZIALI = 80;
	
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private int crediti;
	private int crediti_giornalieri;
	private Date ultimaVisita;

	
	public Utente(String nome, String cognome, String username, String password, int crediti) throws EccezioneUtente {
		
		if(username != null && username != ""
				&& password != null && nome !=null && cognome != null) {
			this.username = username;
			this.password = password;
			this.nome = nome;
			this.cognome = cognome;
			
			if(crediti > 0)
				this.crediti = crediti;
			else this.crediti = getCreditiIniziali();
			
		} else {
			throw new EccezioneUtente(String.format("Bad user/password passed '%s'/'%s'", this.username, this.password));
		}
	}
	
	public Utente(String nome, String cognome, String username, String password, int crediti, Date ultimoLogin) throws EccezioneUtente {
		
		if(username != null && username != ""
				&& password != null && nome !=null && cognome != null) {
			this.username = username;
			this.password = password;
			this.nome = nome;
			this.cognome = cognome;
			
			ultimaVisita = ultimoLogin;
			
			if(crediti > 0)
				this.crediti = crediti;
			else this.crediti = getCreditiIniziali();
			
		} else {
			throw new EccezioneUtente(String.format("Bad user/password passed '%s'/'%s'", this.username, this.password));
		}
	}
	
	public Utente(String username, String password) {
		this.username = username;
		this.password = password;
		this.crediti = getCreditiIniziali();
	}
	
	public Utente(String username) {
		this.username = username;
		this.password = "";
		this.crediti = getCreditiIniziali();
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

	public Date getUltimaVisita() {
		return ultimaVisita;
	}

	public void setUltimaVisita(Date ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}

	public java.sql.Date getUltimaVisitaSQL(){
		long temp = ultimaVisita.getTime();
		return new java.sql.Date(temp);
	}
	
	public int getCrediti_giornalieri() {
		return crediti_giornalieri;
	}

	public void setCrediti_giornalieri(int crediti_giornalieri) {
		this.crediti_giornalieri = crediti_giornalieri;
	}
	
	public void resetCrediti_giornalieri(){
		crediti_giornalieri = 0;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	
	public int aggiungiCrediti(int crediti) {
		
		if(crediti > 0) {
			this.crediti = this.crediti + crediti;
		}
		
		return this.crediti;
	}
	
	public int getCreditiIniziali() {
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
