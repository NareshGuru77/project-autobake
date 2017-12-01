package maas.models;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Order implements Serializable {
	
	String guid;
	String customer_id;
	Date order_date;
	Date delivery_date;
	List<ProductsToOrder> products;
	
	public Order(String guid, String customerId, Date orderDate, Date deliveryDate, List<ProductsToOrder> products) {
		this.guid = guid;
		this.customer_id = customerId;
		this.order_date = orderDate;
		this.delivery_date = deliveryDate;
		this.products = products;
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
	
	public List<ProductsToOrder> getProducts() {
		return products;
	}

}
