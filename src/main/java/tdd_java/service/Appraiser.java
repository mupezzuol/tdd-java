package tdd_java.service;

import tdd_java.model.Auction;
import tdd_java.model.Lance;

public class Appraiser {
	
	private double highestValue = Double.NEGATIVE_INFINITY;
	private double lowerValue = Double.POSITIVE_INFINITY;
	private double average = 0;
	
	public void evaluate(Auction auction) {
		double totalValues = 0;
		
		for (Lance l : auction.getLances()) {
			if (l.getValue() > this.highestValue ) this.highestValue = l.getValue(); 
			if(l.getValue() < this.lowerValue) this.lowerValue = l.getValue();
			totalValues += l.getValue();
		}
		
		if (!(totalValues == 0)) {
			this.average = totalValues / auction.getLances().size();
		}
	}
	
	public double getHighestLance() {
		return this.highestValue;
	}
	
	public double getLowerLance() {
		return this.lowerValue;
	}
	
	public double getAverageLances() {
		return this.average;
	}

}
