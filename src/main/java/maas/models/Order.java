package maas.models;

import java.util.*;


public class Order {
	
	String guid;
	String customer_id;
	Date order_date;
	Date delivery_date;
	ArrayList <ProductsToOrder> productss;
	
	public Order(String guid, String customerId, Date orderDate, Date deliveryDate
			, ArrayList <ProductsToOrder> products) {
		this.guid = guid;
		this.customer_id = customerId;
		this.order_date = orderDate;
		this.delivery_date = deliveryDate;
		this.productss = products;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public String getCustomerId() {
		return customer_id;
	}
	
	public Date getOrderDate() {
		return order_date;
	}
	
	public Date getDeliveryDate() {
		return delivery_date;
	}
	
	public List <ProductsToOrder> getProducts() {
		//return products;
		return null;
	}
	
	public String toString() {
		String string = "";
		for(ProductsToOrder product :productss) {
			string += product.toString() + " ";
		}
		return string;
	}

}
