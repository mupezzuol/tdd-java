package tdd_java.model;

import java.time.YearMonth;

public class LeapYear {
	
	boolean isLeapYear(int ano) {
		YearMonth yearMonth = YearMonth.of(ano, 2);
		int daysInMonth = yearMonth.lengthOfMonth();
		if (daysInMonth == 29) return true;
		return false;
	}

}
