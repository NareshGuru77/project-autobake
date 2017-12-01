package maas.agents;

import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

public class KneadingMachineController extends Agent {

	List<String> kneadingMachineGuids;

	public KneadingMachineController() {
		kneadingMachineGuids = new ArrayList<String>();
	}

	public KneadingMachineController(List<String> guids) {
		kneadingMachineGuids = guids;
	}

	public boolean addGuid(String guid) {
		return kneadingMachineGuids.add(guid);
	}

	@Override
	protected void setup() {
		System.out.println("Hello! KneadingMachineController-agent " + getAID().getName() + " is ready.");

	}

	@Override
	protected void takeDown() {
		System.out.println("KneadingMachineController-agent " + getAID().getName() + " terminated.");
	}
}
