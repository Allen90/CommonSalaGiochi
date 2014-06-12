package userModel;

public class EntryClassifica {
	
	private String nome = "";
	private int crediti = 0;
	
	public EntryClassifica(String nome, int crediti){
		this.nome = nome;
		this.crediti = crediti;
	}

	public EntryClassifica(Utente u, boolean giorn){
		this.nome = u.getNome() + " " + u.getCognome();
	
		if(giorn)
			crediti = u.getCrediti_giornalieri();
		else
			crediti = u.getCrediti();
	}
	
	public String getNome() {
		return nome;
	}

	public int getCrediti() {
		return crediti;
	}
	
	public String toString(){
		return nome + "\t" + crediti;
	}
}
