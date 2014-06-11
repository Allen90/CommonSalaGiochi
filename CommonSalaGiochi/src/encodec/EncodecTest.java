package encodec;

public class EncodecTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "TIPOAZIONE#prova1#prova2";
		System.out.println(s);
		
		System.out.println(Decoder.getTipoAzione(s));
		System.out.println(s);

		
	}

}
