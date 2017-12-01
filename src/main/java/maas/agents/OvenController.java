package maas.agents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jade.core.Agent;

@SuppressWarnings("serial")
public class OvenController extends Agent implements Serializable {

	private List<String> ovenGuids;

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
		Logger log = LogManager.getLogger(OvenController.class);
		log.info("Hello! OvenController-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(OvenController.class);
		log.info("OvenController-agent " + getAID().getName() + " terminated.");
	}
}
