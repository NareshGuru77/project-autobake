package maas;

import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import maas.models.Order;
import maas.models.Reader;
import maas.agents.*;

public class Start {
    public static void main(String[] args) {
    	Logger log = LogManager.getLogger(Start.class);
    	
    	Runtime runtime = Runtime.instance();
    	
    	runtime.setCloseVM(true);
    	
    	Profile profile = new ProfileImpl(null, 1200, null);
    	
    	AgentContainer container = runtime.createMainContainer(profile);
    	
    	Reader reader = new Reader();
    	
    	reader.readJsonFile("src/main/config/random-scenario.json");
    	
    	BakeryController bakeryController = new BakeryController();
    	Bakery[] bakeries = reader.getBakeries();
    	
    	for(int i = 0; i < bakeries.length; ++i) {
    		try {
    			// create and start bakery agent
    			container.acceptNewAgent(bakeries[i].getBakeryName(), bakeries[i]).start();
    			// add guid to bakeryController
    			bakeryController.addGuid(bakeries[i].getGuid());
    			
    			// create agents of the bakery
    			OvenController ovenController = new OvenController();
    			List<Oven> ovens = bakeries[i].getOvens();
    			
    			for(Iterator<Oven> it = ovens.iterator(); it.hasNext();) {
    				Oven oven = it.next();
    				container.acceptNewAgent(bakeries[i].getBakeryName() + ":" + oven.getGuid(), oven).start();
    				ovenController.addGuid(oven.getGuid());
    			}
    			
    			container.acceptNewAgent("OvenController" + i, ovenController).start();
    			
    			KneadingMachineController kneadingMachnineController = new KneadingMachineController();
    			
    			for(int j = 0; j < bakeries[i].getNumberOfKneadingMachines(); ++j) {
    				KneadingMachine kneadingMachine = new KneadingMachine("kneading-machine-" + j);
    				container.acceptNewAgent(bakeries[i].getBakeryName() + ":" + kneadingMachine.getGuid(), kneadingMachine).start();
    				kneadingMachnineController.addGuid(kneadingMachine.getGuid());
    			}
    			
    			container.acceptNewAgent("KneadingMachnineController" + i, kneadingMachnineController).start();
    			
    			Delivery delivery = new Delivery();
    			List<Truck> trucks = bakeries[i].getTrucks();
    			
    			for(Iterator<Truck> it = trucks.iterator(); it.hasNext();) {
    				Truck truck = it.next();
    				container.acceptNewAgent(bakeries[i].getBakeryName() + ":" + truck.getGuid(), truck).start();
    				delivery.addGuid(truck.getGuid());
    			}
    			
    			container.acceptNewAgent("Delivery" + i, delivery).start();
    			
    			container.acceptNewAgent("Packaging" + i, new Packaging()).start();
    			
    		} catch (StaleProxyException e) {
    			log.fatal("Wrapper is outdated", e);
    		}
    	}
    	
    	try {
			container.acceptNewAgent("BakeryController", bakeryController).start();
		} catch (StaleProxyException e) {
			log.fatal("Wrapper is outdated", e);
		}
    	
    	Customer[] customers = reader.getCustomers();
    	
    	Map<String, List<Order>> orderToCustomerMap = new HashMap<String, List<Order>>(customers.length);
    	
    	for(int i = 0; i < customers.length; ++i) {
    		String name = customers[i].getCustomerName();
    		
    		orderToCustomerMap.put(name, new ArrayList<Order>());
    	}
    	
    	Order[] orders = reader.getOrders();
    	
    	for(int i = 0; i < orders.length; ++i) {
    		String customerId = orders[i].getCustomerId();
    		
    		List<Order> orderIdList = orderToCustomerMap.get(customerId);
    		orderIdList.add(orders[i]);
    	}
    	
    	for(int i = 0; i < customers.length; ++i) {
    		customers[i].setOrders(orderToCustomerMap.get(customers[i].getCustomerName()));
    		
    		try {
				container.acceptNewAgent(customers[i].getCustomerName(), customers[i]).start();
			} catch (StaleProxyException e) {
				log.fatal("Wrapper is outdated", e);
			}
    	}
    }
}
