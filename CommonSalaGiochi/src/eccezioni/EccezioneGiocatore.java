package eccezioni;

public class EccezioneGiocatore extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EccezioneGiocatore(String message) {
		super(message);
	}
	
	public EccezioneGiocatore(String message, Throwable throwable) {
		super(message, throwable);
	}
}
