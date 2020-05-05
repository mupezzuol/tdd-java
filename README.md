# TDD with Java

Design for automated test studies.

## Index :pushpin:

- [Sample Codes](#code)
- [Dependencies Used](#maven)

## Sample Codes <a name="code"></a>:white_check_mark:

- First Test.

```java
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
```

## Dependencies Used <a name="maven"></a>:link:

- JUnit Jupiter 5.6.2
