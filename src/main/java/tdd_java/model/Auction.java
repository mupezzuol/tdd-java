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
		if (lances.isEmpty() || canProposeLance(lance.getUser())) {
			lances.add(lance);
		}
	}

	private boolean canProposeLance(User user) {
		return !getLastLance().getUser().equals(user) && lanceAmountOfUser(user) < 5;
	}

	private int lanceAmountOfUser(User user) {
		int total = 0;
		for (Lance l : this.lances) {
			if (l.getUser().equals(user))
				total++;
		}
		return total;
	}

	private Lance getLastLance() {
		return lances.get(lances.size() - 1);
	}

	public String getDescription() {
		return description;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
