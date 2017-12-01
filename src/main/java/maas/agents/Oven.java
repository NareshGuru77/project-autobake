package maas.agents;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.*;

public class Oven extends Agent implements Serializable{
	
	private static final long serialVersionUID = -6570088771410266687L;
	String guid;
	int cooling_rate;
	int heating_rate;
	
	public String getGuid() {
		return guid;
	}

	protected void setup() {
		System.out.println("Hello! Oven-agent " + getAID().getName() + " is ready.");
		
	}
	protected void takeDown() {
		System.out.println("Oven-agent " + getAID().getName() + " terminated.");
	}
	
	private class sendBack extends CyclicBehaviour{
		public void action() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
