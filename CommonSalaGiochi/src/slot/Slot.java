package slot;
/**
 * classe che gestisce le estrazioni
 * @author fritz
 *
 */
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
		j.incJackpot();
		if(c.calcolaPremio() == 100){
			if(j.getJackpot() > 100){
				premio = j.getJackpot();
				if(reset) j.resetJackpot();
			}
			else premio = c.calcolaPremio();
		}
		else 
			premio = c.calcolaPremio();
		return premio;
	}
	
	public String getStringaPremio(){
		int premio = getPremio(false);
		if(premio >= 100){
			return "JACKPOT#";
		}else if(premio == 0){
			return "PERSO#";
		}else{
			return "VINTO#";
		}
	}
	
}
