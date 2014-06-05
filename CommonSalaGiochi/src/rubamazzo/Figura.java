package rubamazzo;

public enum Figura {

	ASSO(1, "asso"),
	DUE(2, "2"), 
	TRE(3, "3"), 
	QUATTRO(4, "4"), 
	CINQUE(5, "5"),
	SEI(6, "6"), 
	SETTE(7, "7"), 
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
