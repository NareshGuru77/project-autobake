package maas.models;

public class Date {
	
	int day;
	int hour;
	public int getDay() {
		return day;
	}
	public int getHour() {
		return hour;
	}
	public Date(int day, int hour) {
		super();
		this.day = day;
		this.hour = hour;
	}
	public Date() {
		super();
		this.day = 0;
		this.hour = 0;
	}

}
