package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		ArrayList<Ship> listFleet = (ArrayList<Ship>)(ArrayList<?>)new ArrayList<Spaceship>(fleet);
		Collections.sort(listFleet);
		ArrayList<String> ret = new ArrayList<>(listFleet.size());
		for (Ship s : listFleet) {
			ret.add(s.toString());
		}
		return ret;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		HashMap<String,Integer> ret = new HashMap<>();
		Integer tmp;
		for (Spaceship s : fleet) {
			tmp = ret.putIfAbsent(s.getClass().getSimpleName(), 1);
			if (tmp!=null) {
				ret.put(s.getClass().getSimpleName(), tmp + 1);
			}
		}
		return ret;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship s : fleet) {
			sum+=s.getAnnualMaintenanceCost();
		}
		return sum;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> ret = new HashSet<>();
		List<Weapon> tmp;
		for (Spaceship s : fleet) {
			if (s instanceof CombatShip) {
				tmp = ((CombatShip) s).weapons;
				for (Weapon w :tmp) {
					ret.add(w.getName());
				}
			}
		}
		return ret;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int count = 0;
		for (Spaceship s : fleet) {
			count += s.getCrewMembers().size();
		}
		return count;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int num = 0, sum = 0;
		Set<? extends CrewMember> tmp; 
		for (Spaceship s : fleet) {
			if (!(s instanceof CylonRaider)) {
				tmp = s.getCrewMembers();
				for (CrewMember c: tmp){
					if (c instanceof Officer) {
						num++;
						sum += c.getAge();
					}
				}
			}
		}
		if (num == 0) {
			return 0;
		}
		return ((sum + 0.0f) /num);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		HashMap<Officer, Spaceship> rankmap = new HashMap<>();
		Set<? extends CrewMember> manifest;
		Officer tmp;
		for (Spaceship s : fleet) {
			if (!(s instanceof CylonRaider)) {
				manifest = s.getCrewMembers();
				tmp = null;
				for (CrewMember m : manifest) {
					if (m instanceof Officer) {
						if (tmp==null || tmp.getRank().compareTo(((Officer)m).getRank()) < 0) {
							tmp = (Officer)m;
						}
					}
				}
				if (tmp!=null) {
					rankmap.put(tmp,s);
				}
			}
		}
		return rankmap;
	}
	
	
	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		HashMap<OfficerRank, Integer> rankmap = new HashMap<>();
		List<Map.Entry<OfficerRank, Integer>> res;
		Set<? extends CrewMember> manifest;
		Integer tmp;
		for (Spaceship s : fleet) {
			if (!(s instanceof CylonRaider)) {
				manifest = s.getCrewMembers();
				for (CrewMember m : manifest) {
					if (m instanceof Officer) {
						tmp = rankmap.putIfAbsent(((Officer)m).getRank(),1);
						if (tmp!=null) {
							rankmap.put(((Officer)m).getRank(),tmp + 1);
						}
					}
				}
			}
		}
		res = new ArrayList<>(rankmap.entrySet());
		Collections.sort(res,(x,y)->x.getKey().compareTo(y.getKey()));
		Collections.sort(res,(x,y)->x.getValue().compareTo(y.getValue()));
		return res;
	}

}
