package maas.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

	private String id;
	private int dough_prep_time;
	private int resting_time;
	private int item_prep_time;
	private int breads_per_oven;
	private int baking_time;
	private int baking_temp;
	private int cooling_rate;
	private int boxing_temp;
	private int breads_per_box;
	private int production_cost;
	private int sales_price;

	public String getId() {
		return id;
	}

	public int getDough_prep_time() {
		return dough_prep_time;
	}

	public int getResting_time() {
		return resting_time;
	}

	public int getItem_prep_time() {
		return item_prep_time;
	}

	public int getBreads_per_oven() {
		return breads_per_oven;
	}

	public int getBaking_time() {
		return baking_time;
	}

	public int getBaking_temp() {
		return baking_temp;
	}

	public int getCooling_rate() {
		return cooling_rate;
	}

	public int getBoxing_temp() {
		return boxing_temp;
	}

	public int getBreads_per_box() {
		return breads_per_box;
	}

	public int getProduction_cost() {
		return production_cost;
	}

	public int getSales_price() {
		return sales_price;
	}

}
