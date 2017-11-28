package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import maas.models.Order;

import java.util.ArrayList;
import java.util.List;

public class BakeryController extends Agent {

	List<String> bakeryGuids;

	public BakeryController() {
		bakeryGuids = new ArrayList<String>();
	}

	public BakeryController(List<String> guids) {
		bakeryGuids = guids;
	}

	public boolean addGuid(String guid) {
		return bakeryGuids.add(guid);
	}

	protected void setup() {
		System.out.println("Hello! BakeryController-agent " + getAID().getName() + " is ready.");

		// Register the bakery-selling service in the yellow pages
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("bakery-controller");
		sd.setName("bakery-controller-name");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}

		addBehaviour(new OrderHandleServer());

	}

	protected void takeDown() {
		System.out.println("BakeryController-agent " + getAID().getName() + " terminated.");
	}

	private class OrderHandleServer extends CyclicBehaviour {
		public void action() {
			ACLMessage msg = myAgent.receive();

			if (msg != null) {
				try {
					Order new_order = ((Order) msg.getContentObject());
					System.out.println("Received Order id: " + new_order.getGuid() + " from Customer: "
							+ new_order.getCustomerId());
					System.out.println("\nOrder Details:\n_______________________\n");
					System.out.println("Order Date: " + new_order.getOrderDate() + " Delivery Date: "
							+ new_order.getDeliveryDate());
				} catch (UnreadableException e) {
					e.printStackTrace();
				}

			} else {
				block();

			}

		}
	} // End of inner class OfferRequestsServer

}
