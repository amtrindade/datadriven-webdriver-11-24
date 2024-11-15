package com.test;

import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.SpreedSheetData;
import com.page.DetailSearchPage;
import com.page.MainPage;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class SearchCountryTest extends BaseTest{
	
	private DetailSearchPage detailPage;
	private MainPage mainPage;
	
	@BeforeTest
	public void beforeTest() {
		mainPage = new MainPage();	
	}
	
	
	@Test(dataProvider = "countriesList")
	public void testSearchCounty(String searchCountry, String expectedCountry ) throws InterruptedException {
		mainPage.openURL();
		detailPage = mainPage.searchCountry(searchCountry);			
		assertEquals(detailPage.getTextTitle(), expectedCountry);		
	}
	
	@Test(dataProvider = "countriesListExcel")
	public void testSearchCountyExcel(String searchCountry, String expectedCountry ) throws InterruptedException {
		mainPage.openURL();
		detailPage = mainPage.searchCountry(searchCountry);			
		assertEquals(detailPage.getTextTitle(), expectedCountry);		
	}

	@DataProvider(name = "countriesList")
	public Object[][] dataProviderCountriesList(){
		return new Object[][] { 
			{ "India", "India" }, 
			{ "Brazil", "Brazil" }, 
			{ "Argentina", "Argentina" },
			{ "Italy", "Italy" },
			{ "Paraguay", "Paraguay" }
		};	
	}
	
	@DataProvider(name = "countriesListExcel")
	public Object[][] dataProviderCountriesListExcel(){
		
		Object[][] testData = SpreedSheetData.readExcelData("Paises"
				, "src" + File.separator + "test" + File.separator + "resources" + File.separator+ "paises.xls"
				, "Dados");
		return testData;
		
	}

}
