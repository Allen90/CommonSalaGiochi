package tombola;
/**
 * classe utilizzata dall'encoder lato client per comunicare al server 
 * la volontà di vincere qualcosa 
 * @author fritz
 *
 */
public class Vincita {
	private int tipoVincita;
	private int indiceCartella;
	private int numPartita;
	private int indiceRiga;
	
	public Vincita(int numPartita, int tipoVittoria, int indiceCartella,int indiceRiga){
		
		this.numPartita = numPartita;
		this.indiceCartella = indiceCartella;
		this.indiceRiga = indiceRiga;
		this.tipoVincita = tipoVittoria;
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
