package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter implements Spaceship{
	protected static int cloackDevices;
	protected final int DEVICE_COST = 50;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		cloackDevices++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon("Laser Cannons",10,100)));
	}
	
	public int getAnnualMaintenanceCost() {
		return (super.getAnnualMaintenanceCost() + (cloackDevices * DEVICE_COST));
	}
	
}
