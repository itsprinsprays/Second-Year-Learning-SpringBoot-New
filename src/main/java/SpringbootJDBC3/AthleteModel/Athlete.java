package SpringbootJDBC3.AthleteModel;

public class Athlete {
	
	private int athleteID,age,sportID;
	private String athleteName;
	
	public Athlete(int athleteID, String athleteName, int age, int sportID) {
		this.athleteID = athleteID;
		this.athleteName = athleteName;
		this.age = age;
		this.sportID = sportID;
	}
	
	public int getAthleteID() {
		return athleteID;
	}
	
	public String getAthleteName() {
		return athleteName;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getSportID() {
		return sportID;
	}
	
	
	public void setAthleteID(int athleteID) {
		this.athleteID = athleteID;
	}
	
	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSportID(int sportID) {
		this.sportID = sportID;
	}

}
