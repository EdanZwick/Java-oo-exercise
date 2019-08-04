package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends CombatShip implements Spaceship{

	protected int numberOfTechnicians;
	public final int BOMBER_ANNUAL_COST = 5000;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}

	public int getAnnualMaintenanceCost() {
		int wCost = (int)((super.weaponMaintCost()) * ( 1 - ((numberOfTechnicians + 0.0) / 10)));
		return (wCost + BOMBER_ANNUAL_COST);
	}
	
	
	public String toString() {
		return (super.toString()+System.lineSeparator()+"\tNumberOfTechnicians="+numberOfTechnicians);
	}
	
}
