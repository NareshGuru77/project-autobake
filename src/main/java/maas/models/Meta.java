package maas.models;


public class Meta {
	
	int bakeries;
	int trucks;
	int products;
	int orders;
	CustomerInformation customers;
	int duration_days;
	/*	
	public Meta(OrderInformation orders, CustomerInformation customers, String total_bakeries, String duration_days) {
		super();
		this.orders = orders;
		this.customers = customers;
		this.total_bakeries = total_bakeries;
		this.duration_days = duration_days;
	}*/
	public int getOrders() {
		return orders;
	}
	public CustomerInformation getCustomers() {
		return customers;
	}
	public int getTotal_bakeries() {
		return bakeries;
	}
	public int getDuration_days() {
		return duration_days;
	}
	

}
