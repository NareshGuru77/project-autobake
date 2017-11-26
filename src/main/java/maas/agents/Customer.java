package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.*;

import java.util.ArrayList;
import java.util.List;

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
		//System.out.println("Customer guid: "+guid+ "; Customer location is: ("+location.getX()+","+location.getY()+")");
		 addBehaviour(new orderProducts());
	}

	protected void takeDown() {
		System.out.println("Customer-agent " + getAID().getName() + " terminated.");
	}

	private class orderProducts extends OneShotBehaviour {
		public void action() {
			System.out.println("\nNumber of orders from customer"+ getAID().getName() +" is: "+orders.size());
			for (Order order :orders){
				System.out.println("\nOrder id:"+order.getGuid());
				System.out.println("\nOrder Date:"+order.getOrderDate().toString()+"; "
						+ "Delivery Date: "+order.getDeliveryDate().toString());
				System.out.println("\nOrder details: \n"
						+ "-----------------------------------");
				int count=0;
				for (ProductsToOrder productsToOrder:order.getProducts()){
					count++;
					System.out.println("\n"+count+") Item:"+productsToOrder.getProductid()+
							"; Quantity: "+productsToOrder.getQuantity());					
				}
			}
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
