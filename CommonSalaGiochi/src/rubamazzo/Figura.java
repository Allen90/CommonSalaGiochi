package rubamazzo;

public enum Figura {

	ASSO(1, "asso"),
	DUE(2, "02"), 
	TRE(3, "03"), 
	QUATTRO(4, "04"), 
	CINQUE(5, "05"),
	SEI(6, "06"), 
	SETTE(7, "07"), 
	FANTE( 8,"fante"), 
	DONNA(9, "donna"), 
	RE(10, "re");

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
