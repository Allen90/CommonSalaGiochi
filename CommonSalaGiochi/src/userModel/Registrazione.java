package userModel;

public class Registrazione extends Login {

	private String confPass;
	private String nome;
	private String cognome;
	
	public Registrazione(String username, String password, String confPass, String nome, String cognome){
		super(username, password);
		this.confPass = confPass;
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getConfPass() {
		return confPass;
	}

	public void setConfPass(String confPass) {
		this.confPass = confPass;
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
	
	
}
