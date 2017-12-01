package maas;

import static org.junit.Assert.*;

import org.junit.Test;

import maas.models.Location;

public class LocationTest {
	int x = 1;
	int y = 2;
	Location actual_location;
	public LocationTest() {
		actual_location=new Location(x,y);
	}
	
	

	@Test
	public void testgetX() {
		assertEquals(x, actual_location.getX());
	}

	@Test
	public void testgetY() {
		assertEquals(y, actual_location.getY());
	}

}

