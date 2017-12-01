package maas.agents;

import maas.models.Location;
import maas.models.StreetNetwork;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jade.core.Agent;
import jade.core.behaviours.*;

@SuppressWarnings("serial")
public class Truck extends Agent implements Serializable {

	String guid;
	int load_capacity;
	Location location;

	public String getGuid() {
		return guid;
	}

	// TODO: Implementation
	protected StreetNetwork path_plan() {

		throw new UnsupportedOperationException();
	}

	// TODO: Implementation
	protected void follow_path() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(Truck.class);
		log.info("Hello! Truck-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(Truck.class);
		log.info("Truck-agent " + getAID().getName() + " terminated.");
	}

	// TODO: Implementation
	private class truckHandleServer extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

}
