package tombola;

public class Vincita {
	private int tipoVincita;
	private int indiceCartella;
	private int numPartita;
	private int indiceRiga;
	
	public Vincita(int numPartita, int tipoVittoria, int indiceCartella,int indiceRiga){
		
		this.numPartita = numPartita;
		this.indiceCartella = indiceCartella;
		this.indiceRiga = indiceRiga;
		this.tipoVincita = tipoVincita;
	}

	public int getTipoVincita() {
		return tipoVincita;
	}

	public int getIndiceCartella() {
		return indiceCartella;
	}


	public int getNumPartita() {
		return numPartita;
	}

	public int getIndiceRiga() {
		return indiceRiga;
	}

	
}
