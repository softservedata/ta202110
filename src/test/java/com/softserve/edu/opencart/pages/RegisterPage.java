package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.data.IUser;

public class RegisterPage extends AccountSidebarGuestPart {

    private WebElement firstname;
    private WebElement lastname;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;
    private WebElement company;
    private WebElement address1;
    private WebElement address2;
    private WebElement city;
    private WebElement postcode;
    private Select country;
    private Select region;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement subscribeYes;
    private WebElement subscribeNo;
    private WebElement privacyPolicy;
    private WebElement continueButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstname = driver.findElement(By.id("input-firstname"));
        lastname = driver.findElement(By.id("input-lastname"));
        email = driver.findElement(By.id("input-email"));
        telephone = driver.findElement(By.id("input-telephone"));
        fax = driver.findElement(By.id("input-fax"));
        company = driver.findElement(By.id("input-company"));
        address1 = driver.findElement(By.id("input-address-1"));
        address2 = driver.findElement(By.id("input-address-2"));
        city = driver.findElement(By.id("input-city"));
        postcode = driver.findElement(By.id("input-postcode"));
        country = new Select(driver.findElement(By.id("input-country")));
        region = new Select(driver.findElement(By.id("input-zone")));
        password = driver.findElement(By.id("input-password"));
        confirmPassword = driver.findElement(By.id("input-confirm"));
        subscribeYes = driver.findElement(By.cssSelector("label.radio-inline > input[value='1']"));
        subscribeNo = driver.findElement(By.cssSelector("label.radio-inline > input[value='0']"));
        privacyPolicy = driver.findElement(By.name("agree"));
        continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
    }

    // Page Object

    // firstname
    public WebElement getFirstname() {
        return firstname;
    }

    public String getFirstnameText() {
        return getFirstname().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setFirstnameField(String text) {
        getFirstname().sendKeys(text);
    }

    public void clearFirstname() {
        getFirstname().clear();
    }

    public void clickFirstname() {
        getFirstname().click();
    }

    // lastname
    public WebElement getLastname() {
        return lastname;
    }

    public String getLastnameText() {
        return getLastname().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setLastnameField(String text) {
        getLastname().sendKeys(text);
    }

    public void clearLastname() {
        getLastname().clear();
    }

    public void clickLastname() {
        getLastname().click();
    }

    // email
    public WebElement getEmail() {
        return email;
    }

    public String getEmailText() {
        return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setEmailField(String text) {
        getEmail().sendKeys(text);
    }

    public void clearEmail() {
        getEmail().clear();
    }

    public void clickEmail() {
        getEmail().click();
    }

    // telephone
    public WebElement getTelephone() {
        return telephone;
    }

    public String getTelephoneText() {
        return getTelephone().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setTelephoneField(String text) {
        getTelephone().sendKeys(text);
    }

    public void clearTelephone() {
        getTelephone().clear();
    }

    public void clickTelephone() {
        getTelephone().click();
    }

    // fax
    public WebElement getFax() {
        return fax;
    }

    public String getFaxText() {
        return getFax().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setFaxField(String text) {
        getFax().sendKeys(text);
    }

    public void clearFax() {
        getFax().clear();
    }

    public void clickFax() {
        getFax().click();
    }

    // company
    public WebElement getCompany() {
        return company;
    }

    public String getCompanyText() {
        return getCompany().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setCompanyField(String text) {
        getCompany().sendKeys(text);
    }

    public void clearCompany() {
        getCompany().clear();
    }

    public void clickCompany() {
        getCompany().click();
    }

    // address1
    public WebElement getAddress1() {
        return address1;
    }

    public String getAddress1Text() {
        return getAddress1().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setAddress1Field(String text) {
        getAddress1().sendKeys(text);
    }

    public void clearAddress1() {
        getAddress1().clear();
    }

    public void clickAddress1() {
        getAddress1().click();
    }

    // address2
    public WebElement getAddress2() {
        return address2;
    }

    public String getAddress2Text() {
        return getAddress2().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setAddress2Field(String text) {
        getAddress2().sendKeys(text);
    }

    public void clearAddress2() {
        getAddress2().clear();
    }

    public void clickAddress2() {
        getAddress2().click();
    }

    // city
    public WebElement getCity() {
        return city;
    }

    public String getCityText() {
        return getCity().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setCityField(String text) {
        getCity().sendKeys(text);
    }

    public void clearCity() {
        getCity().clear();
    }

    public void clickCity() {
        getCity().click();
    }

    // postcode
    public WebElement getPostcode() {
        return postcode;
    }

    public String getPostcodeText() {
        return getPostcode().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setPostcodeField(String text) {
        getPostcode().sendKeys(text);
    }

    public void clearPostcode() {
        getPostcode().clear();
    }

    public void clickPostcode() {
        getPostcode().click();
    }

    // country
    public Select getCountry() {
        return country;
    }

    public WebElement getCountryAsWebElement() {
        return getCountry().getWrappedElement();
    }

    public WebElement getCountrySelected() {
        return getCountry().getFirstSelectedOption();
    }

    public String getCountrySelectedText() {
        return getCountrySelected().getText().trim();
    }

    public void clickCountry() {
        getCountryAsWebElement().click();
    }

    protected void setCountry(String text) {  // TODO Use Enum
        getCountry().selectByVisibleText(text);
    }

    // region
    public Select getRegion() {
        return region;
    }

    public WebElement getRegionAsWebElement() {
        return getRegion().getWrappedElement();
    }

    public WebElement getRegionSelected() {
        return getRegion().getFirstSelectedOption();
    }

    public String getRegionSelectedText() {
        return getRegionSelected().getText().trim();
    }

    public void clickRegion() {
        getRegionAsWebElement().click();
    }

    protected void setRegion(String text) {
        getRegion().selectByVisibleText(text);
    }

    // password
    public WebElement getPassword() {
        return password;
    }

    public String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setPasswordField(String text) {
        getPassword().sendKeys(text);
    }

    public void clearPassword() {
        getPassword().clear();
    }

    public void clickPassword() {
        getPassword().click();
    }

    // confirmPassword
    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public String getConfirmPasswordText() {
        return getConfirmPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void setConfirmPasswordField(String text) {
        getConfirmPassword().sendKeys(text);
    }

    public void clearConfirmPassword() {
        getConfirmPassword().clear();
    }

    public void clickConfirmPassword() {
        getConfirmPassword().click();
    }

    // subscribeYes
    public WebElement getSubscribeYes() {
        return subscribeYes;
    }

    public void clickSubscribeYes() {
        getSubscribeYes().click();
    }

    // subscribeNo
    public WebElement getSubscribeNo() {
        return subscribeNo;
    }


    public void clickSubscribeNo() {
        getSubscribeNo().click();
    }

    // privacyPolicy
    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void clickPrivacyPolicy() {
        getPrivacyPolicy().click();
    }

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional
    private void fillRegistrationForm(IUser user) {
        clickFirstname();
        clearFirstname();
        setFirstnameField(user.getFirstname());
        //
        clickLastname();
        clearLastname();
        setLastnameField(user.getLastname());
        //
        clickEmail();
        clearEmail();
        setEmailField(user.getEmail());
        //
        clickTelephone();
        clearTelephone();
        setTelephoneField(user.getTelephone());
        //
        clickFax();
        clearFax();
        setFaxField(user.getFax());
        //
        clickCompany();
        clearCompany();
        setCompanyField(user.getCompany());
        //
        clickAddress1();
        clearAddress1();
        setAddress1Field(user.getAddress1());
        //
        clickAddress2();
        clearAddress2();
        setAddress2Field(user.getAddress2());
        //
        clickCity();
        clearCity();
        setCityField(user.getCity());
        //
        clickPostcode();
        clearPostcode();
        setPostcodeField(user.getPostcode());
        //
        clickCountry();
        setCountry(user.getCountry()); // TODO
        //
        clickRegion();
        setRegion(user.getRegion()); // TODO
        //
        clickPassword();
        clearPassword();
        setPasswordField(user.getPassword());
        //
        clickConfirmPassword();
        clearConfirmPassword();
        setConfirmPasswordField(user.getPassword());
        //
        if (user.isSubscribe()) {
            clickSubscribeYes();
        } else {
            clickSubscribeNo();
        }
        //
        clickPrivacyPolicy();
        //
        clickContinueButton();
    }

    // Business Logic
    public SuccessRegisterPage successfullRegisterUser(IUser newValidUser) {
        fillRegistrationForm(newValidUser);
        return new SuccessRegisterPage(driver);
    }

    //public RegisterPage unsuccessfullRegisterUser(IUser invalidUser) {
    //}

}