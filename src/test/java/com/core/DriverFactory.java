package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		//Mudar aqui o browser
		String browser = "Firefox";
		
			
		if (driver == null) {
			
			if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
				driver = new ChromeDriver();
			}
			
			else if (browser.equals("Chrome-headless")) {
				System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--windows-size=1200x960");
				
				driver = new ChromeDriver(options);
			}
			
			else if (browser.equals("Firefox")) {
				System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			
			else if (browser.equals("Firefox-headless")) {
				System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--windows-size=1200x960");
				
				driver = new FirefoxDriver(options);
			}
			
			else {
				System.out.println("Browser não foi definido! Verifique as configurações!");
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		return driver;		
	}
	
	public static void killDriver() {
		
		if (driver != null) {
			driver.quit();
			driver = null;		
		}		
	}
	

}
