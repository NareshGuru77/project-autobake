package maas.agents;

import java.util.ArrayList;
import java.util.List;
import jade.core.Agent;

public class OvenController extends Agent {

	List<String> ovenGuids;

	public OvenController() {
		ovenGuids = new ArrayList<String>();
	}

	public OvenController(List<String> guids) {
		ovenGuids = guids;
	}

	public boolean addGuid(String guid) {
		return ovenGuids.add(guid);
	}

	@Override
	protected void setup() {
		System.out.println("Hello! OvenController-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		System.out.println("OvenController-agent " + getAID().getName() + " terminated.");
	}
}
