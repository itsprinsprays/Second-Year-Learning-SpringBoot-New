package SpringbootJDBC3.AthleteModel;

public class Athlete {
	
	private int athleteID,age,sportsID;
	private String athleteName;
	
	public Athlete(int athleteID, String athleteName, int age, int sportsID) {
		this.athleteID = athleteID;
		this.athleteName = athleteName;
		this.age = age;
		this.sportsID = sportsID;
	}

}
