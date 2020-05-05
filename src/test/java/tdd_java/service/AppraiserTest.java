package tdd_java.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tdd_java.model.Auction;
import tdd_java.model.Lance;
import tdd_java.model.User;

public class AppraiserTest {
	
	@Test
	public void mustUnderstandHigherAndLowerLances() {
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

}
