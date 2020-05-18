# TDD with Java

Design for automated test studies.

## Index :pushpin:

- [Sample Codes](#code)
- [TDD](#tdd)
- [Dependencies Used](#maven)

## Sample Codes <a name="code"></a>:white_check_mark:

- First Test.

```java
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
```

- AuctionTest - Method: _`mustReceiveMultipleBids`_

```java
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
```

## TDD <a name="tdd"></a>:chart_with_upwards_trend:

- Demonstrating the magic of TDD in a small gif of the project.
![tdd](resources/tdd-example.gif)

## Dependencies Used <a name="maven"></a>:link:

- JUnit Jupiter 5.6.2
