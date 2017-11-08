package maas;

import java.util.*;

public class Order {
	
	private String customerId;
	private String orderDate;
	private String deliveryDate;
	Vector<Integer> products;
	
	public Order(String customerId, String orderDate, String deliveryDate, Vector<Integer> products) {
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	
	public Vector<Integer> getProducts() {
		return products;
	}

}
