package encodec;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import rubamazzo.Carta;
import rubamazzo.Mossa;
import rubamazzo.MossaSocket;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.Casella;
import tombola.SituazioneTombola;
import tombola.Tabella;
import tombola.Tabellone;
import tombola.Vincita;
import userModel.EntryClassifica;
import userModel.InfoHome;
import userModel.Login;
import userModel.Registrazione;

public class Decoder {

	int cacca;


	private static StringTokenizer st;
	//DECODE GENERALI

	public static String getTipoAzione(String s){
		st = new StringTokenizer(s,"#");
		String output = st.nextToken();
		return output;
	}

	public static InfoHome clientAccesso(String s) throws ParseException{ //sia login che registrazione
		st = new StringTokenizer(s,"#");
		InfoHome i = null;
		if(st.nextToken().equals("OK")){
			String nome = st.nextToken();
			String cognome = st.nextToken();
			int crediti = Integer.parseInt(st.nextToken());

			String target = st.nextToken();
			//DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy",Locale.ENGLISH);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			Date data = dateFormat.parse(target);
			int posizione = Integer.parseInt(st.nextToken());
			i = new InfoHome(nome,cognome,crediti,posizione,data);
		}
		return i;
	}

	public static Login serverLogin(String s){


		String username = st.nextToken();
		String password = st.nextToken();

		Login l = new Login(username, password);
		return l;
	}

	public static Registrazione serverRegistra(String s){
		//st.nextToken(); // rimuovo il token del tipoazione

		String username = st.nextToken();
		String password = st.nextToken();
		String passConf = st.nextToken();
		String nome = st.nextToken();
		String cognome = st.nextToken();

		Registrazione r = new Registrazione(username, password, passConf, nome, cognome);
		return r;
	}

	public static ArrayList<EntryClassifica> clientClassificaGlobale(String s){
		st = new StringTokenizer(s,"#");
		ArrayList<EntryClassifica> classifica = new ArrayList<>();
		st.nextToken();		//rimuovo tag OK
		st.nextToken();	//rimuovo tag CLASSIFICA
		while(st.hasMoreTokens()){
			st.nextToken(); // scarto la posizione;
			classifica.add(new EntryClassifica(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		return classifica;
	}

	public static ArrayList<EntryClassifica> clientClassificaGiornaliera(String s){
		st = new StringTokenizer(s,"#");
		ArrayList<EntryClassifica> classifica = new ArrayList<>();
		st.nextToken();		//rimuovo tag OK
		st.nextToken();	//rimuovo tag CLASSIFICA_G
		while(st.hasMoreTokens()){
			st.nextToken(); // scarto la posizione;
			classifica.add(new EntryClassifica(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		return classifica;
	}

	//SLOT MACHINE

	public static Rollata clientRollata(String s){
		st = new StringTokenizer(s,"#");
		Rollata rollata = new Rollata(st.nextToken().equals("OK"));
		int[] combinazione;
		if(rollata.isValida()){
			combinazione = new int[3];
			for(int i = 0; i<3; i++){
				String temp = st.nextToken();
				if(temp.equals("$"))
					combinazione[i] = 5;
				else
					combinazione[i] = Integer.parseInt(temp);
			}
			rollata.setComb(combinazione);
			rollata.setVincita(st.nextToken());
			rollata.setPremio(Integer.parseInt(st.nextToken()));
			rollata.setCrediti(Integer.parseInt(st.nextToken()));
		}
		return rollata;
	}

	//TOMBOLA

	public static int serverGiocoTombola(String s){
		st = new StringTokenizer(s,"#");
		st.nextToken();		//rimuovo tag GIOCOTOMBOLA
		return Integer.parseInt(st.nextToken());
	}

	public static SituazioneTombola clientAggTombola(String s){
		st = new StringTokenizer(s,"#");
		SituazioneTombola situazione = null;
		String response = st.nextToken();		//rimuovo tag OK
		if(response.equals("OK")){
			int nPartita = Integer.parseInt(st.nextToken());
			String username = st.nextToken();
			int nTabelle = Integer.parseInt(st.nextToken());
			boolean[] premiDisponibili = new boolean[5];

			ArrayList<Tabella> cartelle = new ArrayList<>();
			ArrayList<Casella> temp = new ArrayList<>();
			int[] vincente = new int[Tabella.N_RIGHE];
			for(int i = 0; i < nTabelle; i++){
				for(int j = 0; j < Tabella.DIM_TAB; j++){
					String s1 = st.nextToken();
					if(Integer.parseInt(s1) == 0)
						temp.add(new Casella(0));
					else{
						String s2 = st.nextToken();
						temp.add(new Casella(s1, s2));
					}
//					System.out.println(s1);
//					System.out.println(s2);

				}
				for(int j = 0; j < Tabella.N_RIGHE; j++)
					vincente[j] = Integer.parseInt(st.nextToken());
				Tabella t = new Tabella(temp, vincente);
				cartelle.add(t);
				temp.clear();
			}

			Tabellone tabellone = null;
			for(int i = 0; i < Tabellone.DIM_TAB; i++)
				temp.add(new Casella(st.nextToken(), st.nextToken()));
			tabellone = new Tabellone(temp, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for(int i = 0; i < 5; i++)
				premiDisponibili[i] = Boolean.parseBoolean(st.nextToken());

			situazione = new SituazioneTombola(tabellone, username, cartelle, premiDisponibili, nPartita);

			return situazione;
		}
		else return null;
	}

	public static Vincita serverVincitaTombola(String s){
		st = new StringTokenizer(s,"#");
		Vincita vincita = null;
		st.nextToken();	//rimuovo token VINTOTOMBOLA
		int nPartita = Integer.parseInt(st.nextToken());
		int tipoVittoria = Integer.parseInt(st.nextToken());
		int nCartella = Integer.parseInt(st.nextToken());
		int nRiga = Integer.parseInt(st.nextToken());
		vincita = new Vincita(nPartita, tipoVittoria, nCartella, nRiga);
		return vincita;
	}

	//RUBAMAZZO

	public static SituazioneRubamazzo clientAggRubamazzo(String s){
		
		System.out.println(s);
		
		st = new StringTokenizer(s,"#");
		SituazioneRubamazzo situazione = null;
		ArrayList<Carta> mano = new ArrayList<>();
		ArrayList<Carta> bottini = new ArrayList<>();
		ArrayList<Carta> banco = new ArrayList<>();

		String response = st.nextToken();		
		if(response.equals("OK")){
			
			int nPartita = Integer.parseInt(st.nextToken());
			String username = st.nextToken();
			boolean abilitato = Boolean.parseBoolean(st.nextToken());

			int dimMano = Integer.parseInt(st.nextToken());
			for(int i = 0; i < dimMano; i++)
				mano.add(new Carta(st.nextToken(), st.nextToken()));

			int nGiocatori = Integer.parseInt(st.nextToken());
			for(int i = 0; i < nGiocatori; i++)
				bottini.add(new Carta(st.nextToken(), st.nextToken()));

			while(st.hasMoreTokens())
				banco.add(new Carta(st.nextToken(), st.nextToken()));

			situazione = new SituazioneRubamazzo(username, mano, bottini, banco, nPartita, abilitato);
			return situazione;
		}
		else return null;
	}

	public static MossaSocket serverMossarubamazzo(String s){
		st = new StringTokenizer(s,"#");
		MossaSocket mossaSocket = null;
		Mossa mossa = null;
		ArrayList<Carta> bersagli = new ArrayList<>();
		int bersaglio = 0;

		//st.nextToken();	//rimuovo token MOSSA

		int nPartita = Integer.parseInt(st.nextToken());
		int tipoMossa = Integer.parseInt(st.nextToken());
		Carta giocata = new Carta(st.nextToken(),st.nextToken());

		switch(tipoMossa){
		case 0:
			mossa = new Mossa(giocata);
		case 1:
			bersagli.add(new Carta(st.nextToken(),st.nextToken()));
			mossa = new Mossa(giocata, bersagli.get(0));
		case 2:
			while(st.hasMoreTokens())
				bersagli.add(new Carta(st.nextToken(),st.nextToken()));
			mossa = new Mossa(giocata, bersagli);
		case 3:
			bersaglio = Integer.parseInt(st.nextToken());
			mossa = new Mossa(giocata, bersaglio);
		}

		mossaSocket = new MossaSocket(mossa, nPartita);

		return mossaSocket;
	}

	public static boolean clientResponseVintoTombola(String s){
		st = new StringTokenizer(s,"#");
		String response = st.nextToken();
		if(response.equals("OK"))
			return true;
		else return false;

	}

	public static boolean clientResponseGiocoTombola(String s){
		st = new StringTokenizer(s,"#");
		String response = st.nextToken();
		if(response.equals("OK"))
			return true;
		else return false;

	}

	public static boolean clientResponseGiocoRubamazzo(String s){
		st = new StringTokenizer(s,"#");
		String response = st.nextToken();
		if(response.equals("OK"))
			return true;
		else return false;
	}
	
	public static boolean clientResponseMossaRubamazzo(String s){
		st = new StringTokenizer(s,"#");
		String response = st.nextToken();
		if(response.equals("OK"))
			return true;
		else return false;
	}
	
	public static boolean clientResponseLogout(String s){
		st = new StringTokenizer(s,"#");
		String response = st.nextToken();
		if(response.equals("OK"))
			return true;
		else return false;
	}

}
