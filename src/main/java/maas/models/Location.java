package maas.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Location implements Serializable{
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
