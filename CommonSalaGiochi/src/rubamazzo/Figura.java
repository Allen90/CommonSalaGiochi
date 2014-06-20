package rubamazzo;

public enum Figura {
	
	COPERTA(0, "RETRO"),
	ASSO(1, "ASSO"),
	DUE(2, "2"), 
	TRE(3, "3"), 
	QUATTRO(4, "4"), 
	CINQUE(5, "5"),
	SEI(6, "6"), 
	SETTE(7, "7"), 
	FANTE( 8,"FANTE"), 
	DONNA(9, "DONNA"), 
	RE(10, "RE");

	final String nome;
	final int valore;

	private Figura(int v, String n) {
		nome = n;
		valore = v;
	}

}
