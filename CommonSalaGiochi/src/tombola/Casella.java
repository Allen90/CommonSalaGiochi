package tombola;

public class Casella {

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
