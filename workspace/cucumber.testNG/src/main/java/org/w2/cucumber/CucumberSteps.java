package org.w2.cucumber;

import java.util.HashMap;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class CucumberSteps {

	private static HashMap<Integer,String> scenarios;
	private static Scenario scenario;

	public CucumberSteps(){ //or even inside of your singleton's getInstance();
//		logger.info("Scenario Helper Constructo....");
		System.out.println("Scenario helper constructor....");
	 if(scenarios == null)
	   scenarios = new HashMap<Integer,String>();
	}
	
	//Inorder for before annotation to execute first it should be inside
	//the step definition package/folder that we set as glue in runner file
	@Before
	public void beforeHook(Scenario scenario) {
		System.out.println("Scenario ID: "+scenario.getId());
		System.out.println("Scenario status: "+scenario.getStatus());
		System.out.println("Scenario class: " +scenario.getClass());
		System.out.println("Scenario Tag Names: "+scenario.getSourceTagNames());
		System.out.println("@Before method");
	    addScenario(scenario.getName());
	    this.scenario = scenario;
	}
	
	public static Scenario getScenario1() {
		return scenario;
	}
	
	
	
	private void addScenario(String scenario){
		System.out.println("addScenario() method...");
	     Thread currentThread = Thread.currentThread();
	     int threadID = currentThread.hashCode();
	     scenarios.put(threadID,scenario);
	}

	
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
	
	
}
