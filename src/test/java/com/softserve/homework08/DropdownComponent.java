package com.softserve.homework08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownComponent {

	private WebDriver driver;
	private WebElement euro;
	private WebElement pound;
	private WebElement dollar;

	protected DropdownComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements( ) {
		euro = driver.findElement(By.cssSelector("button[name='EUR']"));
		pound = driver.findElement(By.cssSelector("button[name='GBP']"));
		dollar = driver.findElement(By.cssSelector("button[name='USD']"));
	}

	public WebElement getEuro() {
		return euro;
	}
	
	public void clickEuro() {
		euro.click();
	}

	public String getEuroText() {
		return euro.getText();
	}

	public WebElement getPound() {
		return pound;
	}
	
	public void clickPound() {
		pound.click();
	}

	public String getPoundText() {
		return pound.getText();
	}

	public WebElement getDollar() {
		return dollar;
	}

	public void clickDollar() {
		dollar.click();
	}

	public String getDollarText() {
		return dollar.getText();
	}

	
}
