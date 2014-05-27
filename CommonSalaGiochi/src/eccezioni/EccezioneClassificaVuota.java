package eccezioni;

public class EccezioneClassificaVuota extends Exception {


	private static final long serialVersionUID = 1L;

	public EccezioneClassificaVuota(String message) {
		super(message);
	}
	
	public EccezioneClassificaVuota(String message, Throwable throwable) {
		super(message, throwable);
	}
}
