package maas;

import static org.junit.Assert.*;

import org.junit.Test;

import maas.models.Meta;
import maas.models.CustomerInformation;

public class MetaTest {
	int bakeries;
	int trucks;
	int products;
	int orders;
	CustomerInformation customers;
	int duration_days;
	Meta actual_meta;
	public MetaTest() {
		actual_meta=new Meta(bakeries,trucks,products,
				orders,customers,duration_days);
	}
	
	

	@Test
	public void testgetOrders() {
		assertEquals(orders, actual_meta.getOrders());
	}

	@Test
	public void testgetTotal_bakeries() {
		assertEquals(bakeries, actual_meta.getTotal_bakeries());
	}
	@Test
	public void testgetDuration_days() {
		assertEquals(duration_days, actual_meta.getDuration_days());
	}

}

