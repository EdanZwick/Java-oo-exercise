package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter implements Spaceship {

	public final int CYLON_ANNUAL_COST = 3500;
	
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	public int getAnnualMaintenanceCost() {
		return (CYLON_ANNUAL_COST + (int)(1200 * super.maximalSpeed) + super.weaponMaintCost()
		+ 500*crewMembers.size());
	}
		

}
