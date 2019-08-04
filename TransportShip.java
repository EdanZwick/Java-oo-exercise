package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends Ship implements Spaceship{
	protected int cargoCapacity;
	protected int passengerCapacity;
	protected final int TSHIP_ANNUAL_COST = 3000;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}
	
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	
	public int getFirePower() {
		return super.BASIC_FIRE_RATE;
	}

	public int getAnnualMaintenanceCost() {
		return (TSHIP_ANNUAL_COST+5*cargoCapacity+3*passengerCapacity);
	}
	
	public String toString() {
		return(super.toString() +"\tCargoCapacity="+ cargoCapacity + System.lineSeparator()
		+"\tPassengerCapacity="+passengerCapacity);
	}
	
}
