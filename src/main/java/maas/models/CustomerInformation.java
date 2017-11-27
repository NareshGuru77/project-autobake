package maas.models;

public class CustomerInformation {
	
	int total_type1;
	int total_type2;
	int total_type3;
	public int getTotal_type1() {
		return total_type1;
	}
	public int getTotal_type2() {
		return total_type2;
	}
	public int getTotal_type3() {
		return total_type3;
	}
	public CustomerInformation(int total_type1, int total_type2, int total_type3) {
		super();
		this.total_type1 = total_type1;
		this.total_type2 = total_type2;
		this.total_type3 = total_type3;
	}
	public CustomerInformation() {
		super();
		this.total_type1 = 0;
		this.total_type2 = 0;
		this.total_type3 = 0;
	}


}
