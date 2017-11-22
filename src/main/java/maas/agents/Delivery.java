package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.util.ArrayList;
import java.util.List;

public class Delivery extends Agent {
	
	List<String> truckGuids;
	
	public Delivery() {
		truckGuids = new ArrayList<String>();
	}
	
	public Delivery(List<String> guids) {
		truckGuids = guids;
	}
	
	public boolean addGuid(String guid) {
		return truckGuids.add(guid);
	}
	
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
