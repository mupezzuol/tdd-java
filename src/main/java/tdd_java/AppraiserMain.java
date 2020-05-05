package tdd_java;

import tdd_java.model.Auction;
import tdd_java.model.Lance;
import tdd_java.model.User;
import tdd_java.service.Appraiser;

public class AppraiserMain {
	
	public static void main(String[] args) {
		
		User userMurillo = new User("Murillo");
		User userGabriella = new User("Gabriella");
		User userRaul = new User("Raul");
		
		Auction auction = new Auction("Playstation 4");
		
		auction.propose(new Lance(userMurillo, 110.0));
		auction.propose(new Lance(userGabriella, 431.45));
		auction.propose(new Lance(userRaul, 550.0));

		Appraiser auctioneer = new Appraiser();
		auctioneer.evaluate(auction);
		
		System.out.println("Highest Value: " + auctioneer.getHighestLance());
		System.out.println("Lower Value: " + auctioneer.getLowerLance());
	}
	
}
