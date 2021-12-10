package com.softserve.edu.homework6;

import org.openqa.selenium.By;

public interface WebElements {
    By currencyDropDown = By.xpath("//button[@class = 'btn btn-link dropdown-toggle']");
    By currencyUsd = By.xpath("//button[@name = 'USD']");
    By addMacbookToCard = By.xpath("//a[text()='MacBook']/../../..//span[text()='Add to Cart']");
    By successMessage = By.xpath("//div[@class='alert alert-success']");
    By addIphoneToCard = By.xpath("//a[text()='iPhone 3']/../../..//span[text()='Add to Cart']");
    By shoppingCard = By.xpath("//li//span[text()='Shopping Cart']");
    By changeNumberOfIphone = By.xpath("//div[@class='table-responsive']//a[text()='iPhone 3']/../following-sibling::td/div/input");
    By changeNumberOfMacBook = By.xpath("//div[@class='table-responsive']//a[text()='MacBook']/../following-sibling::td/div/input");
    By refreshNumberOfIphone = By.xpath("//div[@class='table-responsive']//a[text()='iPhone 3']/../following-sibling::td/div//button[@type='submit']");
    By refreshNumberOfMacBook = By.xpath("//div[@class='table-responsive']//a[text()='MacBook']/../following-sibling::td/div//button[@type='submit']");
    By totalPrice = By.xpath("//div[@id='content']/div[@class='row']/div/table/tbody/tr[4]/td[2]");
    By addIphoneToWishList = By.xpath("//a[text()='iPhone 3']/../../..//i[@class='fa fa-heart']");
}
