package com.softserve.homework12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.SearchProduct;
import com.softserve.edu.opencart.data.SearchProductRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.test.TestRunner;

public class HomeworkTest12 extends TestRunner {

	@DataProvider
	public Object[][] dataProducts() {
		return new Object[][] { 
			 { SearchProductRepository.getMacEuro() },
		};
	}

	@Test(dataProvider = "dataProducts")
	public void addProductToCart (SearchProduct product) {

		HomePage homePage = loadApplication()
				.chooseCurrency(product.getCurrency())
                .scrollToProduct(product.getProduct())
                .addProductToCart(product.getProduct());
		presentationSleep(1);
		
		Assert.assertTrue(homePage.getCartButtonText().contains("1 item(s) - 472.33€"));
		presentationSleep(1);
	}
}
