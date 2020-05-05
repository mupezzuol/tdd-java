package tdd_java.service;

import tdd_java.model.Auction;
import tdd_java.model.Lance;

public class Appraiser {
	
	private double highestValue = Double.NEGATIVE_INFINITY;
	private double lowerValue = Double.POSITIVE_INFINITY;

	public void evaluate(Auction auction) {
		for (Lance l : auction.getLances()) {
			if (l.getValue() > this.highestValue ) this.highestValue = l.getValue(); 
			if(l.getValue() < this.lowerValue) this.lowerValue = l.getValue();
		}
	}
	
	public double getHighestLance() {
		return this.highestValue;
	}
	
	public double getLowerLance() {
		return this.lowerValue;
	}

}
