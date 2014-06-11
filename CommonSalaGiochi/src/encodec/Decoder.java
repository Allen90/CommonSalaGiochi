package encodec;

import java.util.ArrayList;
import java.util.StringTokenizer;

import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import userModel.InfoHome;
import userModel.Login;
import userModel.Registrazione;
import userModel.Utente;

public class Decoder {
	
	private static StringTokenizer st;
	
	public static String getTipoAzione(String s){
		st = new StringTokenizer(s,"#");
		String output = st.nextToken();
		return output;
	}
	
	public static InfoHome clientAccesso(String s){ //sia login che registrazione
		st = new StringTokenizer(s,"#");
		InfoHome i = null;
		if(st.nextToken().equals("OK")){
			String nome = st.nextToken();
			String cognome = st.nextToken();
			int crediti = Integer.parseInt(st.nextToken());
			int posizione = Integer.parseInt(st.nextToken());
			i = new InfoHome(nome,cognome,crediti,posizione);
		}
		return i;
	}
	
	public static Login serverLogin(String s){
		st.nextToken(); // rimuovo il token del tipoazione
		
		String username = st.nextToken();
		String password = st.nextToken();
			
		Login l = new Login(username, password);
		return l;
	}
	
	public static Registrazione serverRegistra(String s){
		st.nextToken(); // rimuovo il token del tipoazione
		
		String username = st.nextToken();
		String password = st.nextToken();
		String passConf = st.nextToken();
		String nome = st.nextToken();
		String cognome = st.nextToken();
			
		Registrazione r = new Registrazione(username, password, passConf, nome, cognome);
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
		Rollata rollata = new Rollata(st.nextToken().equals("OK"));
		int[] combinazione;
		if(rollata.isValida()){
			combinazione = new int[3];
			for(int i = 0; i<3; i++)
				combinazione[i] = Integer.parseInt(st.nextToken());
			rollata.setComb(combinazione);
			rollata.setVincita(st.nextToken());
			rollata.setPremio(Integer.parseInt(st.nextToken()));
			rollata.setCrediti(Integer.parseInt(st.nextToken()));
		}
		return rollata;
	}
	
	
}
