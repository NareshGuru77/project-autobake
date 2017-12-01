package maas.agents;

import jade.core.Agent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class KneadingMachineController extends Agent implements Serializable {

	private List<String> kneadingMachineGuids;

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
		Logger log = LogManager.getLogger(KneadingMachineController.class);
		log.info("Hello! KneadingMachineController-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(KneadingMachineController.class);
		log.info("KneadingMachineController-agent " + getAID().getName() + " terminated.");
	}
}
