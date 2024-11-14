package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;;

public class DetailSearchPage {
	
	public String getTextTitle() {
	
		WebElement h1Title = getDriver().findElement(By.xpath("//span[@class='mw-page-title-main']"));		
		return h1Title.getText();
	}

}
