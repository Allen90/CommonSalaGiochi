package slot;

public class Slot {

	private Combinazione c = null;
	private Jackpot j = null;
	
	public Slot(){
		c = new Combinazione();
		j = Jackpot.getInstance();
	}
	
	public int[] calcolaCombinazione(){		
		int[] combinazione = c.calcola();
		return combinazione;		
	}
	
	public int getPremio(boolean reset){
		int premio = 0;
		if(c.calcolaPremio() == 100){
			if(j.getJackpot() > 100){
				premio = j.getJackpot();
				if(reset) j.resetJackpot();
			}
		}
		else 
			premio = c.calcolaPremio();
		return premio;
	}
	
}
