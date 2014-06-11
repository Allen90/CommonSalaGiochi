package rubamazzo;

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
