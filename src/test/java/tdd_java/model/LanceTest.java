package tdd_java.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LanceTest {
	
	private User murilloPezzuol;
	
	@BeforeEach
	public void mustCreateDefaultData() {
		this.murilloPezzuol = new User("Murillo Pezzuol");
	}
	
	@Test
	public void shouldNotCreateLanceWithValueZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Lance(murilloPezzuol, 0);
		});
	}
	
	@Test
	public void shouldNotCreateLanceWithValueLessZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Lance(murilloPezzuol, -1);
		});
	}

}
