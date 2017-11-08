package maas;

import jade.core.Agent;
import jade.core.behaviours.*;



@SuppressWarnings("serial")
public class Customer extends Agent {
	
	Order[] orders;
	
	protected void setup() {
		System.out.println("Hello! Customer-agent " + getAID().getName() + " is ready.");
		
		addBehaviour(new readOrdersFromFile());
		
		for(Order o: orders) {
			long orderDate = Long.parseLong(o.getOrderDate());
			
			final Order order = o;
			
			WakerBehaviour behaviour = new WakerBehaviour(this, orderDate) {
				protected void handleElapsedTimeout() {
					myAgent.addBehaviour(new orderProducts(order));
				}
			};
			
			addBehaviour(behaviour);
		}
	}
	
	protected void takeDown() {
		System.out.println("Customer-agent " + getAID().getName() + " terminated.");
	}
	
	private class orderProducts extends OneShotBehaviour {
		
		Order order;
		
		public orderProducts(Order order) {
			this.order = order;
		}
		
		public void action() {
			
		}
	}
	
	private class readOrdersFromFile extends OneShotBehaviour {
		
		public void action() {
			
		}
	}
	
}