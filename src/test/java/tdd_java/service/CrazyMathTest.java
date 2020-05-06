package tdd_java.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CrazyMathTest {
	
	@Test
	public void mustCalculateNumberGranderThan30(){
		CrazyMath crazyMath = new CrazyMath();
		assertEquals(124, crazyMath.crazyCalculation(31));
	}
	
	@Test
	public void mustCalculateNumberGranderThan10AndLessThan30(){
		CrazyMath crazyMath = new CrazyMath();
		assertEquals(33, crazyMath.crazyCalculation(11));
	}
	
	@Test
	public void mustCalculateNumberLessOrEqualThan10(){
		CrazyMath crazyMath = new CrazyMath();
		assertEquals(20, crazyMath.crazyCalculation(10));
	}

}
