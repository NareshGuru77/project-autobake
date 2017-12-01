package maas.agents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

@SuppressWarnings("serial")
public class Packaging extends Agent {
	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(Packaging.class);
		log.info("Hello! Packaging-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(Packaging.class);
		log.info("Packaging-agent " + getAID().getName() + " terminated.");
	}

	private class sendBack extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

}
