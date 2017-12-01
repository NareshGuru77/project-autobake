package maas.models;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 6220847939127131130L;
	String id;
	int dough_prep_time;
	int resting_time;
	int item_prep_time;
	int breads_per_oven;
	int baking_time;
	int baking_temp;
	int cooling_rate;
	int boxing_temp;
	int breads_per_box;
	int production_cost;
	int sales_price;

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
