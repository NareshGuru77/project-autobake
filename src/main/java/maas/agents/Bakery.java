package maas.agents;

import maas.models.Location;
import maas.models.Product;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class Bakery extends Agent implements Serializable {

	String guid;
	String name;
	Location location;
	int kneading_machines;
	int dough_prep_tables;
	List<Oven> ovens;
	List<Product> products;
	List<Truck> trucks;
	List<KneadingMachine> kneadingMachnines;

	public String getBakeryName() {
		return name;
	}

	public String getGuid() {
		return guid;
	}

	public List<Oven> getOvens() {
		return ovens;
	}

	public List<KneadingMachine> getKneadingMachines() {
		return kneadingMachnines;
	}

	public List<Truck> getTrucks() {
		return trucks;
	}

	public List<Product> getProducts() {
		return products;
	}

	public int getNumberOfKneadingMachines() {
		return kneading_machines;
	}

	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(Bakery.class);
		log.info("Hello! Bakery-agent " + getAID().getName() + " is ready.");

		// Register the bakery-selling service in the yellow pages
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("bakery-sales");
		sd.setName("bakery-sales-team");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			log.error("Error in setting up bakery agent ", fe);
		}

	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(Bakery.class);
		log.info("Bakery-agent " + getAID().getName() + " terminated.");
	}

	protected void make_plan() {
		throw new UnsupportedOperationException();
	}

	private class OrderHandleServer extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
			/*
			 * MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
			 * ACLMessage msg = myAgent.receive(mt); if (msg != null) { // CFP Message
			 * received. Process it String title = msg.getContent(); ACLMessage reply =
			 * msg.createReply();
			 * 
			 * //Double price = (Double) catalogue.get(title); /*if (price != null) { // The
			 * requested item is available for sale. Reply with the price
			 * reply.setPerformative(ACLMessage.PROPOSE);
			 * reply.setContent(String.valueOf(price.doubleValue())); } else { // The
			 * requested item is NOT available for sale.
			 * reply.setPerformative(ACLMessage.REFUSE); reply.setContent("not-available");
			 * } myAgent.send(reply); } else { block(); }
			 */
		}
	}

	private class sendtoKnead extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

		private class sendtoOven extends CyclicBehaviour {
			public void action() {
				throw new UnsupportedOperationException();
			}

		}

		private class sendtoDelivery extends CyclicBehaviour {
			public void action() {
				throw new UnsupportedOperationException();
			}

		}

	}

}
