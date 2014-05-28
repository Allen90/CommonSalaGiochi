package model;

public enum Figura {

	ASSO(1, "asso"),
	DUE(2, "02"), 
	TRE(3, "03"), 
	QUATTRO(4, "04"), 
	CINQUE(5, "05"),
	SEI(6, "06"), 
	SETTE(7, "07"), 
	FANTE( 11,"fante"), 
	DONNA(12, "donna"), 
	RE(13, "re");

	final String nome;
	final int valore;

	private Figura(int v, String n) {
	nome = n;
	valore = v;
	}

	Figura successiva() {
	return Figura.values()[this.ordinal()+1%10];
	}

	Figura precedente() {
	return Figura.values()[this.ordinal()-1%10];
	}
}
