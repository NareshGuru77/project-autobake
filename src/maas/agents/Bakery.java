package maas.agents;

import maas.Location;
import maas.Product;

import jade.core.Agent;
import jade.core.behaviours.*;

import java.util.List;

public class Bakery extends Agent {
	
	String guid;
	String name;
	Location location;
	int kneading_machines;
	int dough_prep_tables;
	List<Oven> ovens;
	List<Product> products;
	List<Truck> trucks;

}
