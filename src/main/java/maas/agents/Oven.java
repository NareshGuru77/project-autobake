package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.*;

public class Oven extends Agent {
	
	String guid;
	int cooling_rate;
	int heating_rate;

	protected void setup() {
		System.out.println("Hello! Oven-agent " + getAID().getName() + " is ready.");
		
	}
	protected void takeDown() {
		System.out.println("Oven-agent " + getAID().getName() + " terminated.");
	}
	
	private class sendBack extends CyclicBehaviour{
		public void action() {
			
		}
		
	}
	
}
