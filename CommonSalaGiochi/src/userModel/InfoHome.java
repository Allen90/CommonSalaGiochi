package userModel;

public class InfoHome {
	
	private String username;
	private int crediti;
	
	public InfoHome(String username, int crediti){
		this.username = username;
		this.crediti = crediti;
	}
	
	public int getCrediti(){
		return crediti;
	}
	
	public String getUsername(){
		return username;
	}
	
}
