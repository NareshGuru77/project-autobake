package maas.agents;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class KneadingMachine extends Agent implements Serializable {

	private static final long serialVersionUID = -2184235363103688526L;
	String guid;

	public KneadingMachine(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return guid;
	}

	protected void setup() {
		System.out.println("Hello! KneadingMachine-agent " + getAID().getName() + " is ready.");

	}

	protected void takeDown() {
		System.out.println("KneadingMachine-agent " + getAID().getName() + " terminated.");
	}

	private class sendBack extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}
}
