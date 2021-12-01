package com.softserve.homework12.tests;


import com.softserve.homework12.data.SearchProduct;
import com.softserve.homework12.data.SearchProductRepository;
import com.softserve.homework12.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductSearchTest extends TestRunner {

    @DataProvider//(parallel = true)
    public Object[][] searchProducts() {
        return new Object[][] {
                //{ SearchProductRepository.getMacDollar() },
                { SearchProductRepository.getMacEuro() },
                //{ SearchProductRepository.getMacPoundSterling() },
        };
    }

    @Test(dataProvider = "searchProducts")
    public void checkFirst(SearchProduct searchProduct) {
        // Steps
        HomePage homePage = loadApplication()
                .chooseCurrency(searchProduct.getCurrency())
                .scrollToProduct(searchProduct.getProduct())
                .addProductToShoppingCart(getProduct().click())
                .getShoppingCart()
                .getShoppingCartText(getShoppingCart().getText())
                .clickShoppingCart(getShoppingCart().click());

        //
        // Check
        Assert.assertTrue(homePage
                .getProductComponentsContainer()
                .getProductComponentPriceByName(searchProduct.getProduct())
                .contains(searchProduct.getPrice()));
        //

    }
}
