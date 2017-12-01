package maas.agents;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jade.core.Agent;
import jade.core.behaviours.*;

@SuppressWarnings("serial")
public class Oven extends Agent implements Serializable {

	private String guid;
	private int cooling_rate;
	private int heating_rate;

	public String getGuid() {
		return guid;
	}

	public int getCooling_rate() {
		return cooling_rate;
	}

	public int getHeating_rate() {
		return heating_rate;
	}

	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(Oven.class);
		log.info("Hello! Oven-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(Oven.class);
		log.info("Oven-agent " + getAID().getName() + " terminated.");
	}

	private class sendBack extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

}
