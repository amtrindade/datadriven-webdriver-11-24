package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage openURL() {
		getDriver().get("https://en.wikipedia.org/");
		return this;
	}
	
	public DetailSearchPage searchCountry(String nameCountry) throws InterruptedException {
		
		WebElement tfSearch = getDriver().findElement(By.name("search"));
		tfSearch.sendKeys(nameCountry);
		//TODO Ajustar espera pelo botão
		Thread.sleep(2000);
		
		WebElement btnSearch = getDriver().findElement(By.xpath("//button[.='Search']"));
		btnSearch.click();
		
		return new DetailSearchPage();
	}

}
