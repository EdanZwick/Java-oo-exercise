package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter implements Spaceship  {

	public final int VIPER_ANNUAL_COST = 4000;
	
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	public int getAnnualMaintenanceCost() {
		return (VIPER_ANNUAL_COST + (int)(500 * super.maximalSpeed) + super.weaponMaintCost()
		+ 500*crewMembers.size());
	}
}
