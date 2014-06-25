package rubamazzo;

import java.util.ArrayList;

import eccezioni.EccezioneRubamazzo;
/**
 * classe che contiene tutta la logica relativa al rubamazzo
 * contiene i metodi che si occupano di distribuire le carte ed effettuare
 * tutti i tipi di mosse lecite 
 * @author fritz
 *
 */
public class TavoloRubamazzo {

	private ArrayList<Carta> banco = null;
	private ArrayList<GiocatoreRubamazzo> giocatori = null;
	private Mazzo mazzo = null;
	private boolean finePartita;

	public ArrayList<GiocatoreRubamazzo> getGiocatori(){
		return giocatori;
	}

	public boolean isFinita(){
		finePartita = mazzoVuoto() && maniVuote();
		return finePartita;
	}

	public TavoloRubamazzo(ArrayList<GiocatoreRubamazzo> giocatori){
		finePartita = false;
		mazzo = Mazzo.nuovo();
		mazzo.mescola();
		this.giocatori = giocatori;
		daiCarteInizio(this.giocatori);
		banco = new ArrayList<Carta>();
		riempiBanco();
	}

	public boolean maniVuote(){
		for(GiocatoreRubamazzo g: giocatori)
			if(g.getMano().size() != 0)
				return false;
		return true;
	}
	
	private boolean mazzoVuoto(){
		if(mazzo.vuoto()) return true;
		else return false;
	}

	public void riempiBanco(){
		banco.addAll(mazzo.pesca(4));
		finePartita = isFinita();
	}

	public boolean daiCarteInizio(ArrayList<GiocatoreRubamazzo> giocatori){
		if(finePartita = isFinita() == true)
			return false;
		else{
			for(GiocatoreRubamazzo g: giocatori)
				g.pesca(mazzo, 3);
			return true;
		}
		
	}
	
	/**
	 * controllo della mossa sulla carta giocata, rispetto a le carte presenti nel banco
	 * @param giocata
	 * @return
	 */

	private boolean controllaMossa(Carta giocata){
		for(Carta c: banco){
			System.out.println("CONFRONTO BANCO "+c.toString() +" "+giocata.toString()+ " " + giocata.confronta(c));
			if(giocata.confronta(c)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * controllo della mossa sulla carta giocata e sulla carta selezionata nel banco
	 * @param giocata
	 * @param inBanco
	 * @return
	 */

	private boolean controllaMossa(Carta giocata, Carta inBanco){
		if(giocata.confronta(inBanco)) return true;
		else return false;
	}
	
	/**
	 * controllo della mossa sulla carta giocata e sulla carte selezionata nel banco
	 * @param giocata
	 * @param inBanco
	 * @return
	 */

	private boolean controllaMossa(Carta giocata, ArrayList<Carta> inBanco){
		if(giocata.confronta(inBanco))	return true;
		else return false;
	}

	/**
	 * controllo della mossa sulla carta giocata e sul bottino avversario selezionato
	 * @param giocata
	 * @param bersaglio
	 * @return
	 */
	private boolean controllaMossa(Carta giocata, GiocatoreRubamazzo bersaglio){
		boolean ok;
		try{
			if(bersaglio.getPrimaBottino().confronta(giocata))
				ok = true;
			else
				ok = false;
		}catch(EccezioneRubamazzo e){
			ok = false;
		}
		return ok;		
	}

	
	/**
	 *  mette se possibile, la carta selezionata nel banco 
	 * @param giocata
	 * @param username
	 * @throws EccezioneRubamazzo
	 */
	public void daGiocatoreABanco(Carta giocata, String username) throws EccezioneRubamazzo{
		int i;
		if(!controllaMossa(giocata)){
			
			throw new EccezioneRubamazzo("Mossa non legale!");
		}
		else{
			for(i = 0; i < giocatori.size(); i++)
				if(giocatori.get(i).getUtente().getUsername().equals(username))
					break;
			giocatori.get(i).giocaCarta(giocata);
			if(giocata.figura.valore == 1){
				giocatori.get(i).aggiungiBottino(banco);
				giocatori.get(i).aggiungiBottino(giocata);
				int k = banco.size();
				for(int j = k-1; j >= 0; j--){
					banco.remove(j);
				}
			}
			else
				banco.add(giocata);
		}
	}
	/**
	 * se possibile prende con la carta selezionata la carta del banco selezionata e le inserisce nel bottino personale
	 * @param giocata
	 * @param inBanco
	 * @param username
	 * @throws EccezioneRubamazzo
	 */
	public void daBancoAGiocatore(Carta giocata, Carta inBanco, String username) throws EccezioneRubamazzo{
		int i;
		ArrayList<Carta> bottino = null;
		if(!controllaMossa(giocata, inBanco)) 
			throw new EccezioneRubamazzo("Mossa non legale!");	
		else{
			for(i = 0; i < giocatori.size(); i++)
				if(giocatori.get(i).getUtente().getUsername().equals(username))
					break;
			giocatori.get(i).giocaCarta(giocata);
			bottino = new ArrayList<Carta>();
			bottino.add(inBanco);
			bottino.add(giocata);
//			banco.remove(inBanco);
			for(int j = 0; j < banco.size(); j++)
				if(inBanco.confrontaCarta(banco.get(j)))
					banco.remove(j);
			giocatori.get(i).aggiungiBottino(bottino);
		}
	}
	/**
	 * se possibile prende con la carta selezionata le carte del banco selezionata e le inserisce nel bottino personale
	 * @param giocata
	 * @param inBanco
	 * @param username
	 * @throws EccezioneRubamazzo
	 */
	public void daBancoAGiocatore(Carta giocata, ArrayList<Carta> inBanco, String username) throws EccezioneRubamazzo{
		int i;
		ArrayList<Carta> bottino = null;
		if(!controllaMossa(giocata, inBanco)) 
			throw new EccezioneRubamazzo("Mossa non legale!");	
		else{
			for(i = 0; i < giocatori.size(); i++)
				if(giocatori.get(i).getUtente().getUsername().equals(username))
					break;
			giocatori.get(i).giocaCarta(giocata);
			bottino = new ArrayList<Carta>();
			bottino.addAll(inBanco);
			bottino.add(giocata);
//			banco.removeAll(inBanco);
			for(int j = 0; j < inBanco.size(); j++)
				for(int k = 0; k < banco.size(); k++)
					if(inBanco.get(j).confrontaCarta(banco.get(k)))
						banco.remove(k);
			giocatori.get(i).aggiungiBottino(bottino);
		}
	}
	
	/**
	 * se possibile prende con la carta selezionata la carta del banco selezionata e le inserisce nel bottino personale
	 * @param username
	 * @param giocata
	 * @param bersaglio
	 * @throws EccezioneRubamazzo
	 */
	
	public void daGiocatoreAGiocatore(String username, Carta giocata, int bersaglio) throws EccezioneRubamazzo{
		int i;
		ArrayList<Carta> bottino = null;
		System.out.println(giocatori.get(bersaglio).getUtente().getUsername());
		if(!controllaMossa(giocata, giocatori.get(bersaglio))){
			throw new EccezioneRubamazzo("Mossa non legale!");	
		}
		else{
 			for(i = 0; i < giocatori.size(); i++)
				if(giocatori.get(i).getUtente().getUsername().equals(username))
					break;
 			System.out.println("INDICE TROVATO "+ i);
			giocatori.get(i).giocaCarta(giocata);
			System.out.println("TOLTA CARTA DA MANO");
			bottino = new ArrayList<Carta>();
			System.out.println("NEW BOTTINO");
			Carta temp;
			System.out.println("CARTA TEMP");
			System.out.println("BERSAGLIO: " + bersaglio);
			int k = giocatori.get(bersaglio).getBottino().size();
			System.out.println("STO PER ENTRARE NEL CICLO RIMOZIONE");
			for(int j = k-1; j > 0; j--){
				temp = giocatori.get(bersaglio).getBottino().get(j);
				bottino.add(temp);
				System.out.println("HO AGGIUNTO LA CARTA "+ temp.toString());
				giocatori.get(bersaglio).getBottino().remove(j);
				System.out.println("HO RIMOSSO LA CARTA "+ temp.toString());
			}
			bottino.add(giocata);
			System.out.println("STAMPO BOTTINO RUBATO CON LA MIA CARTA AL SEGUITO");
			for(Carta c: bottino)
				System.out.println(c.toString());
			giocatori.get(bersaglio).azzeraBottino();
			giocatori.get(i).aggiungiBottino(bottino);
		}
	}

	public ArrayList<String> getVincitore(){
		int max = 0, size = 0;
		ArrayList<String> vincitori = new ArrayList<>();
		for(GiocatoreRubamazzo g : giocatori){
			try {
				size = g.getBottino().size();
			}catch(EccezioneRubamazzo e){
				size = 0;
			}
			if(max > size) max = size;
		}
		for(GiocatoreRubamazzo g : giocatori){
			try {
				size = g.getBottino().size();
			} catch (EccezioneRubamazzo e) {
				size = 0;
			}
			if(size == max)
				vincitori.add(g.getUtente().getUsername());
		}
		return vincitori;
	}

	public int getPremio(){
		return 20*giocatori.size()/getVincitore().size();
	}

	public ArrayList<Carta> getBanco() throws EccezioneRubamazzo{
		if(banco.isEmpty()) 
			throw new EccezioneRubamazzo("Banco vuoto!");
		else return banco;
	}
}






