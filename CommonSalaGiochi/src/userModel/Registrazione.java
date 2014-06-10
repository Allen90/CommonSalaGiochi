package userModel;

public class Registrazione {

	private String username;
	private String pass;
	private String confPass;
	private String nome;
	private String cognome;
	
	public Registrazione(String username, String pass, String confPass, String nome, String cognome){
		this.username = username;
		this.pass = pass;
		this.confPass = confPass;
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
