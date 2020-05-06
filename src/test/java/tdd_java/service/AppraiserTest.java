package tdd_java.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import tdd_java.model.Auction;
import tdd_java.model.Lance;
import tdd_java.model.User;

public class AppraiserTest {
	
	@Test
	public void mustUnderstandLancesOrderAsc() {
		// 1. Scenario
		User userMurillo = new User("Murillo");
		User userGabriella = new User("Gabriella");
		User userRaul = new User("Raul");
		
		Auction auction = new Auction("Playstation 4");
		
		auction.propose(new Lance(userMurillo, 110.0));
		auction.propose(new Lance(userGabriella, 431.45));
		auction.propose(new Lance(userRaul, 550.0));
		
		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		// 3. Validation
		double higherExpected = 550.0;
		double lowerExpected = 110.0;
		
		// 4. Execution
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandLancesOrderDesc() {
		// 1. Scenario
		User userMurillo = new User("Murillo");
		User userGabriella = new User("Gabriella");
		User userRaul = new User("Raul");
		
		Auction auction = new Auction("Playstation 4");
		
		auction.propose(new Lance(userMurillo, 1210.0));
		auction.propose(new Lance(userGabriella, 3431.45));
		auction.propose(new Lance(userRaul, 550.0));
		
		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		// 3. Validation
		double higherExpected = 3431.45;
		double lowerExpected = 550.0;
		
		// 4. Execution
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandLancesOrderRondom() {
		// 1. Scenario
		User userMurillo = new User("Murillo");
		User userGabriella = new User("Gabriella");
		User userRaul = new User("Raul");
		User userSnow = new User("Snow");
		User userPezzuol = new User("Pezzuol");
		
		Auction auction = new Auction("Playstation 4");
		
		auction.propose(new Lance(userMurillo, 110.0));
		auction.propose(new Lance(userGabriella, 3031.45));
		auction.propose(new Lance(userRaul, 550.0));
		auction.propose(new Lance(userSnow, 1550.0));
		auction.propose(new Lance(userPezzuol, 50.0));
		
		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		// 3. Validation
		double higherExpected = 3031.45;
		double lowerExpected = 50.0;
		
		// 4. Execution
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandOneLances() {
		// 1. Scenario
		User userMurillo = new User("Murillo");
		Auction auction = new Auction("Playstation 5");
		
		auction.propose(new Lance(userMurillo, 1234.45));
		
		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		// 3. Validation
		double higherExpected = 1234.45;
		double lowerExpected = 1234.45;
		
		// 4. Execution
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandLancesOfListEmpty() {
		// 1. Scenario
		Auction auction = new Auction("Playstation 4");
		
		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		// 3. Validation
		double higherExpected = Double.NEGATIVE_INFINITY;
		double lowerExpected = Double.POSITIVE_INFINITY;
		
		// 4. Execution
		assertEquals(higherExpected, auctioneer.getHighestLance(), 0.00001);
		assertEquals(lowerExpected, auctioneer.getLowerLance(), 0.00001);
	}
	
	@Test
	public void mustUnderstandAvarageLances() {
		// 1. Scenario
		User userMurillo = new User("John Snow");
		User userGabriella = new User("Jack Teller");
		User userRaul = new User("Drogo");

		Auction auction = new Auction("Xbox One");

		auction.propose(new Lance(userMurillo, 200.0));
		auction.propose(new Lance(userGabriella, 400.0));
		auction.propose(new Lance(userRaul, 900.0));

		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);

		// 3. Validation
		double avarageExpected = 500.00;

		// 4. Execution
		assertEquals(avarageExpected, auctioneer.getAverageLances(), 0.00001);
	}
	
	@Test
	public void mustUnderstandAvarageLancesOfListEmpty() {
		// 1. Scenario
		Auction auction = new Auction("PC Gamer");

		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);

		// 3. Validation
		double avarageExpected = 0.0;

		// 4. Execution
		assertEquals(avarageExpected, auctioneer.getAverageLances(), 0.00001);
	}
	
	@Test
	public void musFindTheBiggestLances() {
		// 1. Scenario
		User userMurillo = new User("Murillo");
		User userGabriella = new User("Gabriella");
		User userRaul = new User("Raul");
		User userSnow = new User("Snow");
		User userPezzuol = new User("Pezzuol");
		
		Auction auction = new Auction("Playstation 4");
		
		auction.propose(new Lance(userMurillo, 110.0));
		auction.propose(new Lance(userGabriella, 3031.45));
		auction.propose(new Lance(userRaul, 550.0));
		auction.propose(new Lance(userSnow, 1550.0));
		auction.propose(new Lance(userPezzuol, 50.0));
		
		// 2. Action
		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		// 3. Validation
		double firstHighest = 3031.45;
		double secondHighest = 1550.0;
		double thirdHighest = 550.00;
		
		// 4. Execution
		assertEquals(4, auctioneer.getHighestLances(4).size(), 0.00001);
		assertEquals(5, auctioneer.getHighestLances(10).size(), 0.00001);
		
		List<Lance> highestLances = auctioneer.getHighestLances(3);
		assertEquals(3, highestLances.size(), 0.00001);//Size List
		assertEquals(firstHighest, highestLances.get(0).getValue(), 0.00001);
		assertEquals(secondHighest, highestLances.get(1).getValue(), 0.00001);
		assertEquals(thirdHighest, highestLances.get(2).getValue(), 0.00001);
	}

}
