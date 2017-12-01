package maas.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class Delivery extends Agent implements Serializable{

	private List<String> truckGuids;

	public Delivery() {
		truckGuids = new ArrayList<>();
	}

	public Delivery(List<String> guids) {
		truckGuids = guids;
	}

	public boolean addGuid(String guid) {
		return truckGuids.add(guid);
	}

	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(Delivery.class);
		log.info("Hello! Delivery-agent " + getAID().getName() + " is ready.");
	}

	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(Delivery.class);
		log.info("Delivery-agent " + getAID().getName() + " terminated.");
	}

	private class sendBack extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

	private class sendToTruck extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

	private class sendToPackaging extends CyclicBehaviour {
		public void action() {
			throw new UnsupportedOperationException();
		}

	}

}
