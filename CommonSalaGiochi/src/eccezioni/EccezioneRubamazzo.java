package eccezioni;

public class EccezioneRubamazzo extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EccezioneRubamazzo(String message) {
		super(message);
	}
	
	public EccezioneRubamazzo(String message, Throwable throwable) {
		super(message, throwable);
	}
}
