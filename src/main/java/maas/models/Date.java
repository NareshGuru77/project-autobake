package maas.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Date implements Serializable {

	int day;
	int hour;

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

}
