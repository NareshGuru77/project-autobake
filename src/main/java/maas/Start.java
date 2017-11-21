package maas;

import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

import maas.agents.Reader;

public class Start {
    public static void main(String[] args) {
    	Runtime runtime = Runtime.instance();
    	
    	runtime.setCloseVM(true);
    	
    	Profile profile = new ProfileImpl(null, 1200, null);
    	
    	AgentContainer container = runtime.createMainContainer(profile);
    	
    	Reader b = new Reader();
    	
    	b.readJsonFile("src/main/config/sample-scenario.json");
    	
    	try {
			container.acceptNewAgent(b.getBakeries()[0].getBakeryName(), b.getBakeries()[0]).start();
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
