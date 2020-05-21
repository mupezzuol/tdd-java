package tdd_java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuctionTest {
	
	private Auction auction;
	private User murilloPezzuol;
	private User stevenJobs;
	private User billGates;
	
	@BeforeEach
	public void mustCreateDefaultData() {
		System.out.println("Before");
		this.auction = new Auction("PS5");
		this.murilloPezzuol = new User("Murillo Pezzuol");
		this.stevenJobs = new User("Steven Jobs");
		this.billGates = new User("Bill Gates");
	}
	
	@Test
	public void mustReceiveALance() {
		assertEquals(0, auction.getLances().size());
		
		auction.propose(new Lance(murilloPezzuol, 8040.00));
		
		assertEquals(1, auction.getLances().size());
		assertEquals(8040.00, auction.getLances().get(0).getValue());
	}
	
	@Test
	public void mustReceiveMultipleBids() {
		assertEquals(0, auction.getLances().size());
		
		auction.propose(new Lance(murilloPezzuol, 8040.00));
		auction.propose(new Lance(stevenJobs, 41.13));
		
		assertEquals(2, auction.getLances().size());
		assertEquals(8040.00, auction.getLances().get(0).getValue());
		assertEquals(41.13, auction.getLances().get(1).getValue());
	}
	
	@Test
	public void mustNotAccept2LancesInARowFromTheSameUser() {
		auction.propose(new Lance(murilloPezzuol, 110.11));
		auction.propose(new Lance(murilloPezzuol, 300.04));
		
		assertEquals(1, auction.getLances().size());
		assertEquals(110.11, auction.getLances().get(0).getValue());
	}
	
	@Test
	public void mustNotAcceptMoreThan5LancesFromTheSameUser() {
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
	
	@Test
	public void mustFindaLastLanceByUserAndCreateLanceWithDoubleValue() {
		User steveJobs = new User("Steve Jobs");
        User billGates = new User("Bill Gates");

        auction.propose(new Lance(steveJobs, 2000));
        auction.propose(new Lance(billGates, 3000));
        auction.doubleLance(steveJobs);

        assertEquals(4000, auction.getLances().get(2).getValue(), 0.00001);
		assertEquals(3, auction.getLances().size());
	}
	
	@Test
    public void mustNotDoubleIfYouHaveAPreviousLance() {
        User steveJobs = new User("Steve Jobs");

        auction.doubleLance(steveJobs);

        assertEquals(0, auction.getLances().size());
    }

}
