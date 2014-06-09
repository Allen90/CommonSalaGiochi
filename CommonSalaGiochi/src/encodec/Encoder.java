package encodec;

import rubamazzo.Carta;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import tombola.Tabella;
import userModel.Utente;

public class Encoder {

	public static final String ok = "OK#";
	public static final String ko = "KO#";
	
	public static final String clientTermina = "TERMINA\n";
	public static final String clientGiocoRumbamazzo = "GIOCORUBAMAZZO\n";
	public static final String clientRolla = "ROLLA\n";
	
	public static final String clientAggiornaRubamazzo = "AGGRUBAMAZZO\n";
	public static final String clientAggiornaTombola = "AGGTOMBOLA\n";
	public static final String clientAggiornaClassifica = "AGGCLASSIFICA\n";
	public static final String clientAggiornaCrediti = "AGGCREDITI\n";
	
	
	/*
	 * TODO
	 * classifiche
	 *
	 * mossa (mossa, numpartita(dentro in situazioneRubamazzo))
	 * vintoTombola (tipo di vittoria, numpartita, tipovittoria, indice cartella, indice riga)
	 * 
	 */
	
	public static String clientLogin(String username, String password){
		String output = new String();
		output += "LOGIN#" + username + "#" + password + "\n";
		return output;
	}
	
	public static String clientRegistra(String username, String password, String confPassword, String nome, String cognome){
		String output = new String();
		output += "REGISTRA#" + username + "#" + password + "#" + confPassword + "#" + nome + "#" + cognome + "\n";
		return output;
	}
	
	public static String serverLogin(Utente utente, int posizione, boolean valido){
		String output;
		if(valido){
			output = new String(ok);
			output += utente.getNome()+"#"+utente.getCognome()+"#"
					+utente.getCrediti()+"#"+utente.getUltimaVisita()+"#"+posizione;
		}else{
			output = new String(ko);
			output += "LOGINERR\n";
		}
		return output;
	}
	
	public static String serverRegistra(Utente utente, int posizione, boolean valido){
		String output;
		if(valido){
			output = serverLogin(utente, posizione,valido);
		}else{
			output = new String(ko);
			output += "REGERR\n";
		}
		return output;
	}
	
	public static String serverRolla(Rollata r){
		String output;
		if(r.isValida()){
			output = new String(ok);

			for(int i = 0; i<3; i++){
				if(r.getComb()[i] == 5) 
					output += "$#";
				else 
					output += r.getComb()[i] + "#";
			}
			
			output += r.getVincita();
			output += r.getPremio() + "#";
			output += r.getCrediti() + "\n";
		}else{
			output = new String(ko) + "NOCREDITI#";
			output += r.getCrediti()+ "\n";
		}
		return output;
	}
	
	public static String serverGiocoRubamazzo(boolean valido, int crediti){
		String output;
		if(valido){
			output = new String(ok);
			output += "INCODA#\n";
		}else{
			output = new String(ko);
			output += "NOCREDITI#" + crediti + "\n"; 
		}
		return output;
	}
	
	public static String serverMossaRubamazzo(boolean valida){
		String output;
		if(valida){
			output = new String(ok);
			output += "MOSSALEGALE\n";
		}else{
			output = new String(ko);
			output += "MOSSAILLEGALE\n";
		}
		return output;
	}
	
	public static String serverGiocoTombola(boolean valido, int crediti){
		String output;
		if(valido){
			output = new String(ok);
			output += "INCODA#\n";
		}else{
			output = new String(ko);
			output += "NOCREDITI#" + crediti + "\n"; 
		}
		return output;
	}
	
	public static String serverAggiornaRubamazzo(SituazioneRubamazzo s){
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
	
	public static String serverAggiornaTombola(SituazioneTombola s){
		String output = new String(ok);
		output += s.getTabelle().size() + "#";
		for(Tabella t: s.getTabelle()){
			output += t.toString();
			for(int i = 0; i < t.getVincente().length; i++)
				output += t.getVincente()[i] + "#";
		}
		output += s.getTabellone().toString();
		for(int i = 0; i<s.getPremiDisponibili().length; i++)
			output += s.getPremiDisponibili()[i] + "#";
		output += "\n";
		return output;
	}
	
	public static String clientGiocoTombola(int nCartelle){
		return "GIOCOTOMBOLA#" + nCartelle + "\n";
	}
}
