package com.core;

import org.testng.annotations.AfterTest;

public class BaseTest {
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		DriverFactory.killDriver();
	}

}
