package il.ac.tau.cs.sw1.ex9.starfleet;

public class Officer extends CrewWoman{
	
	OfficerRank rank;
	
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age,yearsInService,name);
		this.rank = rank;
	}
	
	public OfficerRank getRank() {
		return rank;
	}
	
	public String toString() {
		return("Officer"+System.lineSeparator()
		+super.toString()+"\tRank="+rank.name()+System.lineSeparator());
	}
	
	
}
