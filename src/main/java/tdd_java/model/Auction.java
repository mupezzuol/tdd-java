package tdd_java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auction {

	private String description;
	private List<Lance> lances;
	
	public Auction(String description) {
		this.description = description;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propose(Lance lance) {
		lances.add(lance);
	}

	public String getDescription() {
		return description;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	
}
