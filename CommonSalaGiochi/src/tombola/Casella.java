package tombola;

import java.io.Serializable;
/**
 * classe che rappresenta una singola casellina del tabellone
 * o di una tabella, rappresentata da un intero o da un boolean
 * per identificare se è stato estratto
 * @author fritz
 *
 */
public class Casella implements Serializable{

	private int numero;
	private boolean estratto;

	public Casella (){
		numero = -1;
		estratto = false;
	}
	
	public Casella(int numero){
		this.numero = numero;
		estratto = false;
	}

	public Casella (String numero, String estratto){
		this.numero = Integer.parseInt(numero);
		this.estratto = Boolean.parseBoolean(estratto);  
	}
	
	public Casella (int numero, boolean estratto){
		this.numero = numero;
		this.estratto = estratto;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isEstratto() {
		return estratto;
	}

	public void setEstratto(boolean estratto) {
		this.estratto = estratto;
	}


}
