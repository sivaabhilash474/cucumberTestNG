package org.w2.selnium.utilities;


import java.util.HashMap;

import org.apache.log4j.Logger;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class ScenarioHelper {
	
	Logger logger = Logger.getLogger(ScenarioHelper.class);
	
	
	public static ThreadLocal<Scenario> scenario = new ThreadLocal<Scenario>();
	
	private static HashMap<Integer,String> scenarios;

	public ScenarioHelper(){ //or even inside of your singleton's getInstance();
		logger.info("Scenario Helper Constructo....");
		System.out.println("Scenario helper constructor....");
	 if(scenarios == null)
	   scenarios = new HashMap<Integer,String>();
	}
	
	@Before
	public void beforeHook(Scenario scenario) {
		System.out.println("@Before method");
	    addScenario(scenario.getName());
	}
	
	private void addScenario(String scenario){
		System.out.println("addScenario() method...");
	     Thread currentThread = Thread.currentThread();
	     int threadID = currentThread.hashCode();
	     scenarios.put(threadID,scenario);
	}

//	static Scenario scenario;
	/*
	 * public static String getScenarioName() { String scenarioName = ""; //
	 * System.out.println(scenario.getName());
	 * 
	 * if (scenario != null) { scenarioName = ((Scenario) scenario.get()).getName();
	 * // CucumberLogUtils.logToConsole("Scenario Name: " + scenarioName);
	 * System.out.println("Scenario Name: " +scenarioName); } return scenarioName; }
	 */
	
	private synchronized String getScenario(){
	     Thread currentThread = Thread.currentThread();
	     int threadID = currentThread.hashCode();
	     System.out.println(currentThread.hashCode());
	     System.out.println(scenarios.get(threadID));
	     return scenarios.get(threadID);
	}
	
	public void getScenarioName() {
		this.getScenario();
		
	}
	
	private String getFeatureFileNameFromScenarioId(Scenario scenario) {
	    String featureName = "Feature ";
	    String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
	    featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

	    return featureName;
	}
	
	
}
