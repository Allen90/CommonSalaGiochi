package rubamazzo;

public enum Seme {
	
	SPADE("SPA"), 
	COPPE("COP"), 
	BASTONI("BAS"), 
	DENARI("DEN");

	final String nome;

	private Seme(String n) {
		nome = n;
	}
	
}
