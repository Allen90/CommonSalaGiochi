package eccezioni;

public class EccezioneUtente extends Exception {
	
	private static final long serialVersionUID = 3278334278089660651L;

	public EccezioneUtente(String message) {
		super(message);
	}
	
	public EccezioneUtente(String message, Throwable throwable) {
		super(message, throwable);
	}
}