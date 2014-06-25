package rubamazzo;
/**
 * enum utilizzato dalle singole carte per 
 * l'assegnazione del seme
 * @author fritz
 *
 */
public enum Seme {
	
	COPERTA("VERT"),
	SPA("SPA"), 
	COP("COP"), 
	BAS("BAS"), 
	DEN("DEN");

	final String nome;

	private Seme(String n) {
		nome = n;
	}
	
	private String getNome() {
		return nome;
	}
	
	public static Seme getSemeDaString(String seme) throws IllegalArgumentException {
		for(Seme s:Seme.values()) {
			if(s.getNome().equals(seme)) {
				return s;
			}
		}
		throw new IllegalArgumentException("Valore non presente nell'Enum");
	}
}
