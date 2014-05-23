package model;

public enum Seme {

	SPADE(1, "Spa"), 
	COPPE(10, "Cop"), 
	BASTONI(100, "Bas"), 
	DENARI(1000, "Den");
	
	final String nome;
	final int valore;

	private Seme(int v, String n) {
	nome = n;
	valore = v;
	}
}
