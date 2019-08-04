package il.ac.tau.cs.sw1.ex9.starfleet;

public class CrewWoman extends Crew implements CrewMember {
	public CrewWoman(int age, int yearsInService, String name){
		super(age,yearsInService,name);
	}
	
	public String toString() {
		return("CrewWoman"+System.lineSeparator()+super.toString());
	}
}
