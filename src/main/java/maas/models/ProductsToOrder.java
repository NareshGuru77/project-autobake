package maas.models;

public class ProductsToOrder {
	
	String productid;
	int quantity;
	
	public ProductsToOrder(String productid, int quantity) {
		super();
		this.productid = productid;
		this.quantity = quantity;
	}

	public String getProductid() {
		return productid;
	}

	public int getQuantity() {
		return quantity;
	}

}
