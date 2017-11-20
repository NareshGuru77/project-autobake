package maas.models;


public class Meta {
	
	OrderInformation orders;
	CustomerInformation customers;
	String total_bakeries;
	String duration_days;
	/*	
	public Meta(OrderInformation orders, CustomerInformation customers, String total_bakeries, String duration_days) {
		super();
		this.orders = orders;
		this.customers = customers;
		this.total_bakeries = total_bakeries;
		this.duration_days = duration_days;
	}*/
	public OrderInformation getOrders() {
		return orders;
	}
	public CustomerInformation getCustomers() {
		return customers;
	}
	public String getTotal_bakeries() {
		return total_bakeries;
	}
	public String getDuration_days() {
		return duration_days;
	}
	

}
