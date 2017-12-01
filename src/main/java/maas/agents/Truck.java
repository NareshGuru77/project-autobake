package maas.agents;

import maas.models.Location;
import maas.models.StreetNetwork;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.*;

public class Truck extends Agent implements Serializable {

	private static final long serialVersionUID = -888212390337704863L;
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
		System.out.println("Hello! Truck-agent " + getAID().getName() + " is ready.");

	}

	@Override
	protected void takeDown() {
		System.out.println("Truck-agent " + getAID().getName() + " terminated.");
	}

	// TODO: Implementation
	private class truckHandleServer extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

}
