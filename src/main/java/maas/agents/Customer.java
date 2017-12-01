package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import maas.models.Location;
import maas.models.Order;

@SuppressWarnings("serial")
public class Customer extends Agent {
	
	String guid;
	String name;
	String type;
	Location location;

	List<Order> orders = new ArrayList<Order>();

	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(Customer.class);
		log.info("Hello! Customer-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(Customer.class);
		log.info("Customer-agent " + getAID().getName() + " terminated.");
	}

	private class orderProducts extends OneShotBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}
	}

	public String getGuid() {
		return guid;
	}
	
	public String getCustomerName() {
		return name;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
