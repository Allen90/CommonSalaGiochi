package rubamazzo;

import java.util.ArrayList;

import eccezioni.EccezioneRubamazzo;

public class TavoloRubamazzo {

	private ArrayList<Carta> banco = null;
	private ArrayList<GiocatoreRubamazzo> giocatori = null;
	private Mazzo mazzo = null;
	private boolean finePartita;

	public ArrayList<GiocatoreRubamazzo> getGiocatori(){
		return giocatori;
	}

	public boolean isFinita(){
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

	private boolean mazzoVuoto(){
		if(mazzo.vuoto()) return true;
		else return false;
	}

	public void riempiBanco(){
		banco.addAll(mazzo.pesca(4));
		finePartita = mazzoVuoto();
	}

	public void daiCarteInizio(ArrayList<GiocatoreRubamazzo> giocatori){
		for(GiocatoreRubamazzo g: giocatori){
			g.pesca(mazzo, 3);
		}
		finePartita = mazzoVuoto();
	}

	public void daiCarte(ArrayList<GiocatoreRubamazzo> giocatori){
		for(GiocatoreRubamazzo g: giocatori){
			g.pesca(mazzo);
		}
		finePartita = mazzoVuoto();
	}

	private boolean controllaMossa(Carta giocata){
		for(Carta c: banco){
			System.out.println("CONFRONTO BANCO "+c.toString() +" "+giocata.toString()+ " " + giocata.confronta(c));
			if(giocata.confronta(c)){
				return false;
			}
		}
		return true;
	}

	private boolean controllaMossa(Carta giocata, Carta inBanco){
		if(giocata.confronta(inBanco)) return true;
		else return false;
	}

	private boolean controllaMossa(Carta giocata, ArrayList<Carta> inBanco){
		if(giocata.confronta(inBanco))	return true;
		else return false;
	}

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

	public void daGiocatoreABanco(Carta giocata, String username) throws EccezioneRubamazzo{
		int i;
		System.out.println("CONTROLLO MOSSA" + controllaMossa(giocata));
		if(!controllaMossa(giocata)){
			
			throw new EccezioneRubamazzo("Mossa non legale!");
		}
		else{
			for(i = 0; i < giocatori.size(); i++)
				if(giocatori.get(i).getUtente().getUsername().equals(username))
					break;
			giocatori.get(i).giocaCarta(giocata);
			System.out.println("IN TAVOLO RUBAMAZZO - MANO POST MOSSA: ");
			for(Carta c: giocatori.get(i).getMano())
				System.out.println(c.toString());	
			banco.add(giocata);
			if(giocata.figura.valore == 1){
				giocatori.get(i).aggiungiBottino(banco);
				banco.removeAll(banco);
			}
		}
	}

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
			bottino.add(giocata);
			bottino.add(inBanco);
//			banco.remove(inBanco);
			for(int j = 0; j < banco.size(); j++)
				if(inBanco.confrontaCarta(banco.get(j)))
					banco.remove(j);
			giocatori.get(i).aggiungiBottino(bottino);
		}
	}

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
			bottino.add(giocata);
			bottino.addAll(inBanco);
//			banco.removeAll(inBanco);
			for(int j = 0; j < inBanco.size(); j++)
				for(int k = 0; k < banco.size(); k++)
					if(inBanco.get(j).confrontaCarta(banco.get(k)))
						banco.remove(k);
			giocatori.get(i).aggiungiBottino(bottino);
		}
	}

	public void daGiocatoreAGiocatore(String username, Carta giocata, int bersaglio) throws EccezioneRubamazzo{
		int i;
		ArrayList<Carta> bottino = null;
		if(!controllaMossa(giocata, giocatori.get(bersaglio)))
			throw new EccezioneRubamazzo("Mossa non legale!");	
		else{
			for(i = 0; i < giocatori.size(); i++)
				if(giocatori.get(i).getUtente().getUsername().equals(username))
					break;
			giocatori.get(i).giocaCarta(giocata);
			bottino = new ArrayList<Carta>();
			bottino.add(giocata);
			bottino.addAll(giocatori.get(bersaglio).getBottino());
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






