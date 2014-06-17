package slot;

import java.io.Serializable;

public class Rollata implements Serializable{
	
	private int premio;
	private int crediti;
	private int[] comb;
	private boolean valida;
	private String vincita;
		
	public Rollata(boolean valida){
		this.valida = valida;
	}
	
	public int getPremio() {
		return premio;
	}
	public void setPremio(int premio) {
		this.premio = premio;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public int[] getComb() {
		return comb;
	}
	public void setComb(int[] comb2) {
		this.comb = comb2;
	}

	public boolean isValida() {
		return valida;
	}

	public String getVincita() {
		return vincita;
	}

	public void setVincita(String vincita) {
		this.vincita = vincita;
	}
	
}
