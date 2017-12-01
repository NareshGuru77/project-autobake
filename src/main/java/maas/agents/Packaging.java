package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Packaging extends Agent {
	@Override
	protected void setup() {
		System.out.println("Hello! Packaging-agent " + getAID().getName() + " is ready.");

	}

	@Override
	protected void takeDown() {
		System.out.println("Packaging-agent " + getAID().getName() + " terminated.");
	}

	private class sendBack extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

}
