package tombola;

import java.util.ArrayList;
import java.util.Random;

import tombola.Casella;
import tombola.Tabellone;

public class Tabella {
	
	private final int N_RIGHE = 3;
	private final int N_COLONNE = 9;
	private final int N_VUOTI = 4;
	
	private Casella tabella[][];
	private Random r;
	private int[] vincente;
	
	public Tabella(){
		tabella = new Casella[N_RIGHE][N_COLONNE];
		vincente = new int[N_RIGHE];
		r = new Random();		


		for(int i=0; i<N_RIGHE; i++)
			vincente[i] = 0;	

		Tabellone t = new Tabellone();
		int estratto = 0;
		
		for(int decina=0; decina<N_COLONNE; decina++)
			for(int j=0; j<N_RIGHE; j++){
				tabella[j][decina].setNumero(t.estraiDaDecina(decina));
			}		
		for(int i=0;i<N_RIGHE;i++)
			for(int j=0;j<N_VUOTI;j++){
				do{
					estratto = r.nextInt(N_COLONNE);
				}while(tabella[i][estratto].getNumero() == 0);
				tabella[i][estratto].setNumero(0);
			}
	}
	
	public Tabella(ArrayList<Casella> caselle, int[] vincente){
		tabella = new Casella[N_RIGHE][N_COLONNE];
		r = new Random();
		for(int i=0; i<N_RIGHE; i++)
			for(int j=0; j<N_COLONNE; j++){
				tabella[i][j].setNumero(caselle.get(N_COLONNE*i + j).getNumero());
				tabella[i][j].setEstratto(caselle.get(N_COLONNE*i + j).isEstratto());
			}
		
		this.vincente = vincente;
	}
	
	public int getNumero(int riga, int colonna){
		return tabella[riga][colonna].getNumero();
	}
	
	
	
	public boolean isEstratto(int riga, int colonna){
		return tabella[riga][colonna].isEstratto();
	}
	
	public void stampa(){
		for(int i=0;i<N_RIGHE;i++){
			for(int j=0;j<N_COLONNE;j++){
				if(tabella[i][j].getNumero() != 0)
					System.out.print(tabella[i][j]+"\t");
				else System.out.print(" \t");
			}
			System.out.println();
		}
	}
	
	public String toString(){
		String output = "";
		for(int i=0;i<N_RIGHE;i++){
			for(int j=0;j<N_COLONNE;j++){
				if(tabella[i][j].getNumero() != 0){
					output += tabella[i][j].isEstratto() + "#";
				}else{
					output += "0#";
				}
			}
		}
		return output;
	}
	
	public void setEstratto(int riga, int colonna, boolean estratto){
		tabella[riga][colonna].setEstratto(estratto);
	}
	
	public void controllaEstratto(int estratto){
		for(int i = 0; i<N_RIGHE; i++)
			for(int j = 0; j<N_COLONNE; j++)
				if(getNumero(i, j) == estratto)
					setEstratto(i, j, true);
		setVincente();
	}
	
	private int statusVincita(int numeroTrue){
		if(numeroTrue < 2) return 0;
		else return numeroTrue;
	}
	
	//TODO: controllo per le tombolel
	private void setVincente(){
		int contaTrue = 0;
		for(int i = 0; i < N_RIGHE; i++)
			if(vincente[i] != 1){
				for(int j = 0; j<N_COLONNE; j++)
					if(isEstratto(i, j))
						contaTrue++;
				vincente[i] = statusVincita(contaTrue);
				contaTrue = 0;
			}else vincente[i] = 1;
		
		
	}
	
	public void rigaVinta(int i){
		vincente[i] = 1;
	}
	
	public int[] getVincente(){
		return vincente;
	}
}
