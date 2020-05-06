package tdd_java.service;

public class CrazyMath {
	
	public int crazyCalculation(int number) {
		if (number > 30)
			return number * 4;
		else if (number > 10)
			return number * 3;
		else
			return number * 2;
	}

}
