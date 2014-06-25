package rubamazzo;
/**
 * classe utlizzata per l'invio di una mossa rubamazzo attraverso il socket
 * viene richiamata dall'ecoder per trasformarla in una stringa
 * @author fritz
 *
 */
public class MossaSocket {
	private Mossa m;
	private int numPartita;
	
	public MossaSocket(Mossa m,int numPartita){
		this.m = m;
		numPartita = numPartita;
	}
	
	public Mossa getMossa(){
		return m;
	}
	
	public int getNumPartita(){
		return numPartita;
	}

}
