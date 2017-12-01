package maas.models;

public class Location {
	
	int x;
	int y;
	public Location(int x2, int y2) {
		// TODO Auto-generated constructor stub
		x = x2;
		y = y2;		
		System.out.println(x2);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
