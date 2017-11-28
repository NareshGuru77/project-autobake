package maas.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import maas.models.Date;
import maas.models.Location;
import maas.models.Order;
import maas.models.Product;
import maas.models.ProductsToOrder;

@SuppressWarnings("serial")
public class Customer extends Agent {

	String guid;
	String name;
	String type;
	Location location;

	List<Order> orders = new ArrayList<Order>();

	protected void setup() {
		System.out.println("Hello! Customer-agent " + getAID().getName() + " is ready.");

		// Register the bakery-selling service in the yellow pages
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("customer");
		sd.setName(getAID().getName());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}

		// System.out.println("Customer guid: "+guid+ "; Customer location is:
		// ("+location.getX()+","+location.getY()+")");
		addBehaviour(new orderProducts(orders.get(0)));
	}

	protected void takeDown() {
		System.out.println("Customer-agent " + getAID().getName() + " terminated.");
	}

	private class orderProducts extends OneShotBehaviour {
		Order new_order;

		// TODO: Remove Constructor and send orders one by one
		public orderProducts(Order order) {
			Date check_date = new Date();
			ProductsToOrder products = new ProductsToOrder("test", 5);
			ArrayList<ProductsToOrder> check_products = new ArrayList<ProductsToOrder>();
			check_products.add(products);
			new_order = new Order("guid_check", "customerId_check", check_date, check_date, check_products);
		}

		public void action() {
			// Update the list of seller agents
			DFAgentDescription template = new DFAgentDescription();
			ServiceDescription sd = new ServiceDescription();
			sd.setType("bakery-controller");
			template.addServices(sd);
			
			AID[] sellerAgents = null;
			try {
				DFAgentDescription[] result = DFService.search(myAgent, template); 
				System.out.println("Found the following bakery controller agents:");
				sellerAgents = new AID[result.length];
				for (int i = 0; i < result.length; ++i) {
					sellerAgents[i] = result[i].getName();
					System.out.println(sellerAgents[i].getName());
				}
			}
			catch (FIPAException fe) {
				fe.printStackTrace();
			}
			
			//System.out.println("\nNumber of orders from customer" + getAID().getName() + " is: " + orders.size());
			jade.lang.acl.ACLMessage aclmsg = new ACLMessage(ACLMessage.REQUEST);
			if(sellerAgents != null) {
				aclmsg.addReceiver(sellerAgents[0]);
			}
			

			try {
				aclmsg.setContentObject(new_order.toString());
				send(aclmsg);
			} catch (IOException e) {
				e.printStackTrace();
			}

			/*
			 * for (Order order :orders){ System.out.println("\nOrder id:"+order.getGuid());
			 * System.out.println("\nOrder Date:"+order.getOrderDate().toString()+"; " +
			 * "Delivery Date: "+order.getDeliveryDate().toString());
			 * System.out.println("\nOrder details: \n" +
			 * "-----------------------------------"); int count=0; for (ProductsToOrder
			 * productsToOrder:order.getProducts()){ count++;
			 * System.out.println("\n"+count+") Item:"+productsToOrder.getProductid()+
			 * "; Quantity: "+productsToOrder.getQuantity()); } }
			 */

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
