package tdd_java.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd_java.model.Auction;
import tdd_java.model.Lance;
import tdd_java.model.User;
import tdd_java.model.builder.AuctionBuilder;

public class AppraiserTest {
	
	private Appraiser auctioneer;
	private User murilloPezzuol;
	private User stevenJobs;
	private User billGates;
	
	@BeforeEach
	public void setUp() {
		this.auctioneer = new Appraiser();
		this.murilloPezzuol = new User("Murillo Pezzuol");
		this.stevenJobs = new User("Steven Jobs");
		this.billGates = new User("Bill Gates");
	}
	
	@Test
	public void mustUnderstandLancesOrderAsc() {
		Auction auction = new AuctionBuilder().to("Macbook Pro 5")
				.lance(murilloPezzuol, 110.00)
				.lance(murilloPezzuol, 431.45)
				.lance(billGates, 550.00)
				.build();
		
		auctioneer.evaluate(auction);
		
		double higherExpected = 550.00;
		double lowerExpected = 110.00;
		
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandLancesOrderDesc() {
		Auction auction = new AuctionBuilder().to("Macbook Pro 5")
				.lance(murilloPezzuol, 1210.00)
				.lance(stevenJobs, 3431.45)
				.lance(billGates, 550.00)
				.build();
		
		auctioneer.evaluate(auction);
		
		double higherExpected = 3431.45;
		double lowerExpected = 550.00;
		
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandLancesOrderRondom() {
		Auction auction = new AuctionBuilder().to("Macbook Pro 5")
				.lance(murilloPezzuol, 110.0)
				.lance(stevenJobs, 3031.45)
				.lance(billGates, 550.0)
				.lance(murilloPezzuol, 1550.0)
				.lance(billGates, 50.0)
				.build();
		
		auctioneer.evaluate(auction);
		
		double higherExpected = 3031.45;
		double lowerExpected = 50.0;
		
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandOneLances() {
		Auction auction = new AuctionBuilder().to("PS5")
				.lance(murilloPezzuol, 1234.45).build();
		
		auctioneer.evaluate(auction);
		
		double higherExpected = 1234.45;
		double lowerExpected = 1234.45;
		
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandLancesOfListEmpty() {
		double higherExpected = Double.NEGATIVE_INFINITY;
		double lowerExpected = Double.POSITIVE_INFINITY;
		
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandAvarageLances() {
		Auction auction = new AuctionBuilder().to("PS5")
				.lance(murilloPezzuol, 200.0)
				.lance(stevenJobs, 400.0)
				.lance(billGates, 900.0)
				.build();
		
		auctioneer.evaluate(auction);

		double avarageExpected = 500.00;

		assertEquals(avarageExpected, auctioneer.getAverageLances(), 0.00001);
	}
	
	@Test
	public void mustUnderstandAvarageLancesOfListEmpty() {
		double avarageExpected = 0.0;
		assertEquals(avarageExpected, auctioneer.getAverageLances(), 0.00001);
	}
	
	@Test
	public void musFindTheBiggestLances() {
		Auction auction = new AuctionBuilder().to("PS5")
				.lance(murilloPezzuol, 110.0)
				.lance(stevenJobs, 3031.45)
				.lance(billGates, 550.0)
				.lance(murilloPezzuol, 1550.0)
				.lance(stevenJobs, 50.0)
				.build();
		
		auctioneer.evaluate(auction);
		
		double firstHighest = 3031.45;
		double secondHighest = 1550.0;
		double thirdHighest = 550.00;
		
		assertEquals(4, auctioneer.getHighestLances(4).size(), 0.00001);
		assertEquals(5, auctioneer.getHighestLances(10).size(), 0.00001);
		
		List<Lance> highestLances = auctioneer.getHighestLances(3);
		assertEquals(3, highestLances.size(), 0.00001);//Size List
		assertEquals(firstHighest, highestLances.get(0).getValue(), 0.00001);
		assertEquals(secondHighest, highestLances.get(1).getValue(), 0.00001);
		assertEquals(thirdHighest, highestLances.get(2).getValue(), 0.00001);
	}

}
