package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class CombatShip extends Ship implements Spaceship {
	
	List<Weapon> weapons;
	
	public CombatShip(String name, int comissionYear, float maximalSpeed, Set<? extends CrewMember> members, List<Weapon> weapons) {
		super(name, comissionYear, maximalSpeed, members);
		this.weapons = new ArrayList<>(weapons);
	}

	@Override
	public int getFirePower() {
		int power = 0;
		for (Weapon w: weapons) {
			power += w.getFirePower();
		}
		return (super.BASIC_FIRE_RATE + power);
	}
	
	protected int weaponMaintCost() {
		int cost = 0;
		for (Weapon w: weapons) {
			 cost += w.getAnnualMaintenanceCost();
		}
		return (cost);
	}
	
	public String toString() {
		return (super.toString() + "\tWeaponArray=" + Arrays.deepToString(weapons.toArray()));
	}

}
