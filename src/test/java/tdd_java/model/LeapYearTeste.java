package tdd_java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeapYearTeste {
	
	@Test
	public void mustBeLeapYear() {
		LeapYear leapYear = new LeapYear();
		assertEquals(true, leapYear.isLeapYear(2016));
		assertEquals(true, leapYear.isLeapYear(2020));
		assertEquals(true, leapYear.isLeapYear(2024));
	}
	
	@Test
	public void mustNotBeLeapYear() {
		LeapYear leapYear = new LeapYear();
		assertEquals(false, leapYear.isLeapYear(2017));
		assertEquals(false, leapYear.isLeapYear(2018));
		assertEquals(false, leapYear.isLeapYear(2021));
		assertEquals(false, leapYear.isLeapYear(2022));
		assertEquals(false, leapYear.isLeapYear(2023));
	}

}
