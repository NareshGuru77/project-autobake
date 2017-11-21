package maas.agents;

import maas.models.Location;
import maas.models.StreetNetwork;
import jade.core.Agent;
import jade.core.behaviours.*;

public class Truck extends Agent {

	String guid;
	int load_capacity;
	Location location;
	
	//TODO: Check return type
	protected StreetNetwork path_plan(){
		
		return null;		
	}
	
	protected void follow_path(){
		
	}
	
	protected void setup() {
		System.out.println("Hello! Truck-agent " + getAID().getName() + " is ready.");
		
	}
	protected void takeDown() {
		System.out.println("Truck-agent " + getAID().getName() + " terminated.");
	}
	
	private class truckHandleServer extends CyclicBehaviour{
		public void action() {
			
		}
		
	}
	
}
