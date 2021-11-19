package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebElement;

public class AccountLogoutPage extends AccountSidebarGuestPart {

    private WebElement continueButton;

    //public AccountLogoutPage(WebDriver driver) {
    public AccountLogoutPage() {
        //super(driver);
        super();
        initElements();
        //ApplicationStatus.get().setLogged(false);
    }

    private void initElements() {
        //continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='common/home']"));
        //
        continueButton = search.cssSelector("a.btn.btn-primary[href*='common/home']");
    }

    // Page Object

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public HomePage gotoContinue() {
        clickContinueButton();
        //return new HomePage(driver);
        return new HomePage();
    }

}
