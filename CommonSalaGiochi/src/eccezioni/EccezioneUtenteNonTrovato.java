package eccezioni;

public class EccezioneUtenteNonTrovato extends Exception {

	private static final long serialVersionUID = 1L;

	public EccezioneUtenteNonTrovato(String message) {
		super(message);
	}
	
	public EccezioneUtenteNonTrovato(String message, Throwable throwable) {
		super(message, throwable);
	}
}
