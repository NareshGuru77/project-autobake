package maas.models;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Order implements Serializable {
	
	private String guid;
	private String customer_id;
	private Date order_date;
	private Date delivery_date;
	private List<ProductsToOrder> products;
	
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
