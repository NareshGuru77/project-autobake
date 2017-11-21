package maas.agents;

//Class for accepting orders and sending orders to factory

import java.util.Hashtable;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BakerySales extends Agent {
	//private Hashtable catalogue;
	
	protected void setup() {
		System.out.println("Hello! Bakery Seller-agent " + getAID().getName() + " is ready.");
		
		// Register the bakery-selling service in the yellow pages
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("bakery-sales");
		sd.setName("bakery-sales-team");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
		addBehaviour(new OrderHandleServer());	
	}
	
	protected void takeDown() {
		System.out.println("Bakery Seller-agent " + getAID().getName() + " terminated.");
	}
	/**
	   Inner class OfferRequestsServer.
	   This is the behaviour used by Bakery-seller agents to serve incoming requests 
	   for offer from customer agents.
	   If the requested item is in the local catalogue the seller agent replies 
	   with a PROPOSE message specifying the price. Otherwise a REFUSE message is
	   sent back.
	 */
	private class OrderHandleServer extends CyclicBehaviour {
		public void action() {
			boolean correct_order= false;
			MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
			ACLMessage msg = myAgent.receive(mt);
			if (msg != null) {
				// CFP Message received. Process it
				String title = msg.getContent();
				ACLMessage reply = msg.createReply();
				//TODO
				//Check if the ordered product exists.
				
				correct_order=true;
				
				if (correct_order) {
					
					reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
					
				}
				else {
					// The requested item is NOT available for sale.
					reply.setPerformative(ACLMessage.REFUSE);
					reply.setContent("not-available");
				}
				myAgent.send(reply);
			}
			else {
				block();
			}
		}
	}  // End of inner class OfferRequestsServer
	
	private class readOrders extends OneShotBehaviour {
		
		public void action() {
			
		}
	}

}
