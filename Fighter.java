package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends CombatShip implements Spaceship {
	
	protected final int FIGHTER_ANNUAL_COST = 2500;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	public int getAnnualMaintenanceCost() {
		return (FIGHTER_ANNUAL_COST + super.weaponMaintCost() + (int)(1000 * super.maximalSpeed));
	}		
}

