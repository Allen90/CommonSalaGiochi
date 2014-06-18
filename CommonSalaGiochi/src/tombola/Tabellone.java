package tombola;

import java.util.ArrayList;
import java.util.Random;

import tombola.Casella;

public class Tabellone { 
	
	public static final int N_RIGHE = 9;
	public static final int N_COLONNE = 10;
	public static final int DIM_TAB = N_COLONNE * N_RIGHE;
	
	private Casella[][] numeri;
	private Random estrattore;
	private int estratti = 0;
	private int ultimoEstratto = 0;

	public Tabellone(){
		numeri = new Casella[N_RIGHE][N_COLONNE];
		estrattore = new Random();
		riempi();
		estratti = 0;
		ultimoEstratto = 0;

	}
	
	public Tabellone(ArrayList<Casella> numeri, int estratti, int ultimoEstratto){
		estrattore = new Random();
		this.estratti = estratti;
		this.ultimoEstratto = ultimoEstratto;
		
		int indice = 0;
		for(int i=0;i<N_RIGHE;i++)
			for(int j=0;j<N_COLONNE;j++){
				this.numeri[i][j] = numeri.get(indice);
				indice ++;
			}
	}
	
	public void resetta(){
		riempi();
		estratti = 0;
		ultimoEstratto = 0;

	}
	
	public Casella[][] getTabellone(){
		return numeri;
	}
	
	public int getUltimoEstratto(){
		return ultimoEstratto;
	}
	
	private void riempi(){
		int n = 0;
		System.out.println("qui dentro riempi");
		for(int i=0;i<N_RIGHE;i++)
			for(int j=0;j<N_COLONNE;j++){
				n = i*N_COLONNE+j+1;
				System.out.println(n);
				numeri[i][j] = new Casella(n);
			}
	}
	
	public int estrai(){
		int estratto = 0;
		int decine = 0, unita = 0; 
		do{
			estratto = estrattore.nextInt(DIM_TAB)+1;
			unita = estratto%N_COLONNE;
			decine = (estratto - unita)/N_COLONNE;
			System.out.println("estratto:" + estratto);
			System.out.println("unita:" + unita);
			System.out.println("decina:" + decine);
		}while(numeri[decine][unita-1].isEstratto());
		numeri[decine][unita-1].setEstratto(true);;
		estratti ++;
		ultimoEstratto = estratto;
		return estratto;
	}	
	
	public boolean terminato(){
		if(estratti == DIM_TAB)
			return true;
		else return false;
	}
	
	@Override
	public String toString(){
		String output = "";
		for(int i=0;i<N_RIGHE;i++)
			for(int j=0;j<N_COLONNE;j++){
				output += numeri[i][j].getNumero() + "#";
				output += numeri[i][j].isEstratto() + "#";
			}
		output += estratti + "#";
		output += ultimoEstratto + "#";
		return output;
	}
	
	
	
//	public void stampa(){
//		for(int i=0;i<N_RIGHE;i++){
//			for(int j=0;j<N_COLONNE;j++)
//				System.out.print(numeri[i][j]+"\t");
//			System.out.println();
//		}
//	}
	
	public int estraiDaDecina(int decina){
		int estratto = 0;
		int unita = 0;
		do{
			unita = estrattore.nextInt(N_COLONNE);
			estratto = numeri[decina][unita].getNumero();
		}while(numeri[decina][unita].isEstratto());
		numeri[decina][unita].setEstratto(true);;
		return estratto;
	}
	
	

	
}
