package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Delivery extends Agent {
	String guid;
	
	protected void setup() {
		System.out.println("Hello! Delivery-agent " + getAID().getName() + " is ready.");
		
	}
	protected void takeDown() {
		System.out.println("Delivery-agent " + getAID().getName() + " terminated.");
	}
	
	private class sendBack extends CyclicBehaviour{
		public void action() {
			
		}
		
	}
	
	private class sendToTruck extends CyclicBehaviour{
		public void action() {
			
		}
		
	}
	private class SendToPackaging extends CyclicBehaviour{
		public void action() {
			
		}
		
	}

}
