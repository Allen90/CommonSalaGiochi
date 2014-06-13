package encodec;

import java.util.ArrayList;

import rubamazzo.Carta;
import rubamazzo.Mossa;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import tombola.Tabella;
import userModel.EntryClassifica;
import userModel.Utente;

public class Encoder {

	public static final String ok = "OK#";
	public static final String ko = "KO#";
	
	public static final String clientTermina = "TERMINA";
	public static final String clientGiocoRumbamazzo = "GIOCORUBAMAZZO";
	public static final String clientRolla = "ROLLA";
	
	public static final String clientAggiornaRubamazzo = "AGGRUBAMAZZO";
	public static final String clientAggiornaTombola = "AGGTOMBOLA";
	public static final String clientAggiornaClassifica = "AGGCLASS";
	public static final String clientAggiornaCrediti = "AGGCREDITI";
	
	public static String clientLogin(String username, String password){
		String output = new String();
		output += "LOGIN#" + username + "#" + password;
		return output;
	}
	
	public static String clientRegistra(String username, String password, String confPassword, String nome, String cognome){
		String output = new String();
		output += "REGISTRA#" + username + "#" + password + "#" + confPassword + "#" + nome + "#" + cognome;
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
			output += "LOGINERR";
		}
		return output;
	}
	
	public static String serverRegistra(Utente utente, int posizione, boolean valido){
		String output;
		if(valido){
			output = serverLogin(utente, posizione,valido);
		}else{
			output = new String(ko);
			output += "REGERR";
		}
		return output;
	}
	
	public static String serverClassifica(ArrayList<EntryClassifica> classifica){
		String output = new String(ok);
		int i = 1;
		output += "CLASSIFICA#";
		for(EntryClassifica e : classifica){
			output += i + "#" + e.getNome() + "#";
			output += e.getCrediti() + "#";
		}
		return output;
	}
	
	
	//SLOT MACHINE
	
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
			output += r.getCrediti();
		}else{
			output = new String(ko) + "NOCREDITI#";
			output += r.getCrediti();
		}
		return output;
	}
	
	//RUBAMAZZO
	
	public static String serverGiocoRubamazzo(boolean valido, int crediti){
		String output;
		if(valido){
			output = new String(ok);
			output += "INCODA#";
		}else{
			output = new String(ko);
			output += "NOCREDITI#" + crediti; 
		}
		return output;
	}
	
	public static String serverMossaRubamazzo(boolean valida){
		String output;
		if(valida){
			output = new String(ok);
			output += "MOSSALEGALE";
		}else{
			output = new String(ko);
			output += "MOSSAILLEGALE";
		}
		return output;
	}
	
	public static String serverAggiornaRubamazzo(SituazioneRubamazzo s){
		String output = new String(ok);
		output += s.getPartita() + "#";
		output += s.getUsername() + "#";
		output += s.getAbilitato() + "#";
		for(Carta c : s.getMano())
			output += c.toString() + "#";
		for(Carta c : s.getBottini())
			output += c.toString() + "#";
		for(Carta c : s.getBanco())
			output +=c.toString() + "#";
		return output;
	}
	
	public static String clientMossaRubamazzo(Mossa m, int nPartita){
		String output = new String("MOSSA#");
		output += nPartita + "#";
		output += m.getTipoMossa() + "#";
		output += m.getCartaGiocata() + "#";
		switch(m.getTipoMossa()){
		case 0:
			output += m.getCartaBersaglio().toString();
		case 1:
			for(Carta c : m.getCarteBersaglio())
				output += c.toString();
		case 2: 
			output += m.getGiocatoreBersaglio() + "#";
		}
		return output;
	}
	
	
	//TOMBOLA
	
	public static String serverGiocoTombola(boolean valido, int crediti){
		String output;
		if(valido){
			output = new String(ok);
			output += "INCODA#";
		}else{
			output = new String(ko);
			output += "NOCREDITI#" + crediti; 
		}
		return output;
	}
	
	public static String serverAggiornaTombola(SituazioneTombola s){
		String output = new String(ok);
		output += s.getNumeroPartita() + "#";
		output += s.getUsername() + "#";
		output += s.getTabelle().size() + "#";
		for(Tabella t: s.getTabelle()){
			output += t.toString();
			for(int i = 0; i < t.getVincente().length; i++)
				output += t.getVincente()[i] + "#";
		}
		output += s.getTabellone().toString();
		for(int i = 0; i<s.getPremiDisponibili().length; i++)
			output += s.getPremiDisponibili()[i] + "#";;
		return output;
	}
	
	public static String clientVintoTombola(int nPartita, int tipoVittoria, int cartella, int riga){
		String output = new String(ok);
		output += "VINTOTOMBOLA#" + nPartita + "#" + tipoVittoria + "#" + cartella + "#" + riga;
		return output;
	}
	
	public static String clientGiocoTombola(int nCartelle){
		return "GIOCOTOMBOLA#" + nCartelle;
	}
	
	public static String serverResponseVintoTombola(Boolean valido){
		if(valido)
			return ok;
		else return ko;
	}
	
	
}
