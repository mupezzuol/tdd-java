package tdd_java.model.builder;

import tdd_java.model.Auction;
import tdd_java.model.Lance;
import tdd_java.model.User;

public class AuctionBuilder {

	private Auction auction;

	public AuctionBuilder to(String description) {
		this.auction = new Auction(description);
		return this; // return same class 'AuctionBuilder' for use Designer Pattern Builder
	}

	public AuctionBuilder lance(User user, double value) {
		this.auction.propose(new Lance(user, value));
		return this;
	}

	public Auction build() {
		return this.auction;
	}

}
