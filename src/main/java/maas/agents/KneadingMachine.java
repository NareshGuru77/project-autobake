package maas.agents;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

@SuppressWarnings("serial")
public class KneadingMachine extends Agent implements Serializable {

	private String guid;

	public KneadingMachine(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return guid;
	}

	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(KneadingMachine.class);
		log.info("Hello! KneadingMachine-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(KneadingMachine.class);
		log.info("KneadingMachine-agent " + getAID().getName() + " terminated.");
	}

	private class sendBack extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}
}
