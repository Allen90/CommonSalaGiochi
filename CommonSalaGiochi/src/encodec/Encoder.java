package encodec;

import rubamazzo.Carta;
import rubamazzo.SituazioneRubamazzo;

public class Encoder {

	public static final String ok = "OK#";
	public static final String ko = "KO#";
	
	public static String aggiornaRubamazzo(SituazioneRubamazzo s){
		String output = new String(ok);
		for(Carta c : s.getMano())
			output += c.toString() + "#";
		for(Carta c : s.getBottini())
			output += c.toString() + "#";
		for(Carta c : s.getBanco())
			output +=c.toString() + "#";
		output += s.getAbilitato() + "\n";
		return output;
	}
	
}
