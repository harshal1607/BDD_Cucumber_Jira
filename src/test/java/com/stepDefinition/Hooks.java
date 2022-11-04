package com.stepDefinition;

import com.generic.BaseTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private BaseTest objBaseTest;
	
	public Hooks(){
		objBaseTest = new BaseTest();		
	}

	
	@Before
	public void BeforeHookMethod(){
		System.out.println("Before Hook executed");
		objBaseTest.intializeWebEnvironment();
	}
	@After
	public void AfterHookMethod(){
		objBaseTest.tearDownWebEnvironment();
		System.out.println("After Hook executed");
		
	}
}
