package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends Crew implements CrewMember {
	protected int modelNumber;
	
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age,yearsInService,name);
		this.modelNumber = modelNumber;
	}
	
	public int getModelNumber() {
		return modelNumber;
	}
	
	public String toString() {
		return("Cylon"+System.lineSeparator()
		+super.toString()+"\tModelNumber="+modelNumber+System.lineSeparator());
	}

}
