package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;
import java.util.HashSet;

public abstract class Ship implements Spaceship, Comparable<Ship>{
	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected Set<? extends CrewMember> crewMembers;
	public final int BASIC_FIRE_RATE = 10;
		
	public Ship (String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> members){
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = new HashSet<>(members);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getCommissionYear() {
		return commissionYear;
	}

	@Override
	public float getMaximalSpeed() {
		return maximalSpeed;
	}

	@Override
	public Set<? extends CrewMember> getCrewMembers() {
		return new HashSet<>(crewMembers);
	}
	
	public String toString() {
		return(this.getClass().getSimpleName() + System.lineSeparator() +
				"\tName="+ name +System.lineSeparator()+"\tCommissionYear="+commissionYear
				+System.lineSeparator()+"\tMaximalSpeed="+maximalSpeed+System.lineSeparator()
				+"\tFirePower="+this.getFirePower()+System.lineSeparator()
				+"\tCrewMembers="+crewMembers.size()+System.lineSeparator()
				+"\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+System.lineSeparator());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(Ship other) {
		if (other==null) {
			return 1;
		}
		int dif = this.getFirePower() - other.getFirePower();
		if (dif!=0) {
			return -dif;
		}
		dif = this.commissionYear - other.commissionYear;
		if (dif!=0) {
			return -dif;
		}
		return this.name.compareTo(other.name);
	}
	
}
