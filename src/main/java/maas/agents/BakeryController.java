package maas.agents;

import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

public class BakeryController extends Agent {

	List<String> bakeryGuids;
	
	public BakeryController() {
		bakeryGuids = new ArrayList<String>();
	}
	
	public BakeryController(List<String> guids) {
		bakeryGuids = guids;
	}
	
	public boolean addGuid(String guid) {
		return bakeryGuids.add(guid);
	}
	
	@Override
	protected void setup() {
		System.out.println("Hello! BakeryController-agent " + getAID().getName() + " is ready.");
		
	}
	
	@Override
	protected void takeDown() {
		System.out.println("BakeryController-agent " + getAID().getName() + " terminated.");
	}
}
