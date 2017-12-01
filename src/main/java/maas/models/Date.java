package maas.models;

public class Date {
	
	
	int day;
	int hour;
	
	public Date(int day2, int hour2) {
		// TODO Auto-generated constructor stub
		day = day2;
		hour = hour2;		
		System.out.println(day2);
	}
	public int getDay() {
		return day;
	}
	public int getHour() {
		return hour;
	}

}
