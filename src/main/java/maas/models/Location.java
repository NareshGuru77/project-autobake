package maas.models;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 751972746311485117L;
	int x;
	int y;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
