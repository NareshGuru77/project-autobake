package maas.models;

public class Meta {

	private int bakeries;
	private int trucks;
	private int products;
	private int orders;
	private CustomerInformation customers;
	private int duration_days;

	public int getNumberOfOrders() {
		return orders;
	}

	public CustomerInformation getCustomers() {
		return customers;
	}

	public int getNumberOfBakeries() {
		return bakeries;
	}

	public int getDurationDays() {
		return duration_days;
	}

	public int getNumberOfTrucks() {
		return trucks;
	}

	public int getNumberOfProducts() {
		return products;
	}

}
