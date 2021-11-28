package com.softserve.homework11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.test.TestRunner;

public class CurrencyTest extends TestRunner {

	@DataProvider
	public Object[][] dataCurrency() {
		return new Object[][] { 
			{ Currencies.EURO }, 
			
		};
	}

	@Test(dataProvider = "dataCurrency")
	public void changeCurrency(Currencies currency) {

		HomePage homePage = loadApplication()
				.scrollToMacBook()
				.choosePriceMacBook();
					
		//check the currency by price 	
		String priceMacBook = homePage.getPriceMacBookText();
		Assert.assertTrue(priceMacBook.contains("$"));
		
		//change currently to Euro
		HomePage homePageNew = loadApplication()
				.chooseCurrency(currency)
				.scrollToMacBook()
				.choosePriceMacBook();
			
		//check the currency by price 	
		String priceMacBookNew = homePageNew.getPriceMacBookText();
		Assert.assertTrue(priceMacBookNew.contains("€"));
		
		//check the currency change by comparing the price
		Assert.assertNotEquals(priceMacBook, priceMacBookNew);
	}
}
