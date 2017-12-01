package maas.agents;

import jade.core.Agent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class BakeryController extends Agent implements Serializable{

	List<String> bakeryGuids;
	
	public BakeryController() {
		bakeryGuids = new ArrayList<>();
	}
	
	public BakeryController(List<String> guids) {
		bakeryGuids = guids;
	}
	
	public boolean addGuid(String guid) {
		return bakeryGuids.add(guid);
	}
	
	@Override
	protected void setup() {
		Logger log = LogManager.getLogger(BakeryController.class);
		log.info("Hello! BakeryController-agent " + getAID().getName() + " is ready.");
	}
	
	@Override
	protected void takeDown() {
		Logger log = LogManager.getLogger(BakeryController.class);
		log.info("BakeryController-agent " + getAID().getName() + " terminated.");
	}
}
