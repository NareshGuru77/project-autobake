package maas;

import static org.junit.Assert.*;

import org.junit.Test;

import maas.models.CustomerInformation;

public class CustomerInformationTest {
	int total_type1=1;
	int total_type2=2;
	int total_type3=3;
	CustomerInformation actual_customer;
	public CustomerInformationTest() {
		actual_customer=new CustomerInformation(total_type1,total_type2,total_type3);
	}
	
	@Test
	public void testGetTotal_type1() {
		System.out.println("testing");
		assertEquals(total_type1, actual_customer.getTotal_type1());		
	}

	@Test
	public void testGetTotal_type2() {
		assertEquals(total_type2, actual_customer.getTotal_type2());
	}

	@Test
	public void testGetTotal_type3() {
		assertEquals(total_type3, actual_customer.getTotal_type3());
	}

}

