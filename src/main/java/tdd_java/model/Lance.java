package tdd_java.model;

public class Lance {

	private User user;
	private double value;
	
	public Lance(User user, double value) {
		this.user = user;
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public double getValue() {
		return value;
	}
	
}
