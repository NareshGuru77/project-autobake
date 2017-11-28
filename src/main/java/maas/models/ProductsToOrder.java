package maas.models;

public class ProductsToOrder{
	
	String productid;
	int quantity;
	
	public ProductsToOrder(String productid, int quantity) {
		this.productid = productid;
		this.quantity = quantity;
	}

	public String getProductid() {
		return productid;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return productid + ":" + quantity;
	}

}
