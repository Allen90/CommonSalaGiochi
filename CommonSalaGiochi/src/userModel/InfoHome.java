package userModel;

public class InfoHome {
	
	private String nome;
	private String cognome;
	private int crediti;
	private int posizione;
	
	public InfoHome(String nome, String cognome, int crediti, int posizione){
		this.nome = nome;
		this.cognome = cognome;
		this.crediti = crediti;
		this.posizione = posizione;
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
