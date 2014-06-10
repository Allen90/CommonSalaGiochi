package encodec;

import java.util.ArrayList;
import java.util.StringTokenizer;

import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import userModel.Registrazione;
import userModel.Utente;

public class Decoder {
	
	private static StringTokenizer st;
	
	public static String getAzione(String s){
		st = new StringTokenizer(s,"#");
		String output = null;
		
		return output;
	}
	
	public static Utente clientLogin(String s){
		st = new StringTokenizer(s,"#");
		Utente u = null;
		
		return u;
	}
	
	public static Registrazione clientRegistra(String s){
		st = new StringTokenizer(s,"#");
		Registrazione r = null;
		
		return r;
	}
	
	public static ArrayList<String> clientClassificaGlobale(String s){
		st = new StringTokenizer(s,"#");
		ArrayList<String> classifica = null;
		return classifica;
	}
	
	public static SituazioneTombola clientAggTombola(String s){
		st = new StringTokenizer(s,"#");
		SituazioneTombola situazione = null;
		return situazione;
	}
	
	public static SituazioneRubamazzo clientAggRubamazzo(String s){
		st = new StringTokenizer(s,"#");
		SituazioneRubamazzo situazione = null;
		return situazione;
	}
	
	public static Rollata clientRollata(String s){
		st = new StringTokenizer(s,"#");
		Rollata rollata = null;
		return rollata;
	}
	
	
}
