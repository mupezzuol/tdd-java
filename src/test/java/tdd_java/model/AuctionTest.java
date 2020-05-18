package tdd_java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AuctionTest {
	
	@Test
	public void mustReceiveALance() {
		Auction auction = new Auction("PS5");
		assertEquals(0, auction.getLances().size());
		
		auction.propose(new Lance(new User("MuPezzuol"), 8040.00));
		
		assertEquals(1, auction.getLances().size());
		assertEquals(8040.00, auction.getLances().get(0).getValue());
	}
	
	@Test
	public void mustReceiveMultipleBids() {
		Auction auction = new Auction("PS5");
		assertEquals(0, auction.getLances().size());
		
		auction.propose(new Lance(new User("MuPezzuol"), 8040.00));
		auction.propose(new Lance(new User("GaPezzuol"), 41.13));
		
		assertEquals(2, auction.getLances().size());
		assertEquals(8040.00, auction.getLances().get(0).getValue());
		assertEquals(41.13, auction.getLances().get(1).getValue());
	}
	
	@Test
	public void mustNotAccept2LancesInARowFromTheSameUser() {
		Auction auction = new Auction("PS5");
		
		User userMu = new User("MuPezzuol");
		
		auction.propose(new Lance(userMu, 110.11));
		auction.propose(new Lance(userMu, 300.04));
		
		assertEquals(1, auction.getLances().size());
		assertEquals(110.11, auction.getLances().get(0).getValue());
	}
	
	@Test
	public void mustNotAcceptMoreThan5LancesFromTheSameUser() {
		Auction auction = new Auction("PS5");
		
		User stevenJobs = new User("Steven Jobs");
		User billGates = new User("Bill Gates");
		
		auction.propose(new Lance(stevenJobs, 100.00));
		auction.propose(new Lance(billGates, 200.00));
		
		auction.propose(new Lance(stevenJobs, 100.00));
		auction.propose(new Lance(billGates, 200.00));
		
		auction.propose(new Lance(stevenJobs, 100.00));
		auction.propose(new Lance(billGates, 200.00));
		
		auction.propose(new Lance(stevenJobs, 100.00));
		auction.propose(new Lance(billGates, 200.00));
		
		auction.propose(new Lance(stevenJobs, 100.00));
		auction.propose(new Lance(billGates, 200.00));
		
		//Not permit
		auction.propose(new Lance(stevenJobs, 100.00));
		auction.propose(new Lance(billGates, 200.00));
		
		assertEquals(10, auction.getLances().size());
		assertEquals(200.00, auction.getLances().get(auction.getLances().size()-1).getValue());
	}

}
