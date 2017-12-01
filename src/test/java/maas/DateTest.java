
package maas;

import static org.junit.Assert.*;

import org.junit.Test;

import maas.models.Date;
import maas.models.Date ;
public class DateTest {
	int day = 1;
	int hour = 2;
	Date actual_date;
	public DateTest() {
		actual_date=new Date(day,hour);
		
		System.out.println(actual_date.getDay());
	}
	
	public void testgetDay() {
		assertEquals(day, actual_date.getDay());
	}

	@Test
	public void testgetHour() {
		assertEquals(hour, actual_date.getHour());
	}


}

