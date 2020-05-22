package tdd_java.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import tdd_java.model.Auction;
import tdd_java.model.Lance;

public class Appraiser {
	
	private double highestValue = Double.NEGATIVE_INFINITY;
	private double lowerValue = Double.POSITIVE_INFINITY;
	private double average = 0;
	private List<Lance> highestLances = new ArrayList<>();
	
	public void evaluate(Auction auction) {
		double totalValues = 0;
		
		if (auction.getLances().size() == 0) {
			throw new RuntimeException("It is not possible to evaluate an Auction without Lances!");
		}
		
		for (Lance l : auction.getLances()) {
			if (l.getValue() > this.highestValue ) this.highestValue = l.getValue(); 
			if(l.getValue() < this.lowerValue) this.lowerValue = l.getValue();
			totalValues += l.getValue();
		}
		
		if (!(totalValues == 0)) {
			this.average = totalValues / auction.getLances().size();
			this.highestLances = auction.getLances().stream()
					.sorted(Comparator.comparingDouble(Lance::getValue).reversed())
					.collect(Collectors.toList());
		}
	}
	
	public List<Lance> getHighestLances(int index) {
		if (this.highestLances.isEmpty() || this.highestLances.size() < index) {
			return this.highestLances;
		}
		return this.highestLances.subList(0, index);
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
