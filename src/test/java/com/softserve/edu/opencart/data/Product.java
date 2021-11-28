package com.softserve.edu.opencart.data;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private String name;
    private String description;
    private String priceDollarExTax;
    // TODO
    // private Map<Currencies, Decimal> prices;
    private Map<Currencies, String> prices;

    public Product(String name, String description, String priceDollarExTax) {
        this.name = name;
        this.description = description;
        this.priceDollarExTax = priceDollarExTax;
        prices = new HashMap<Currencies, String>();
        //prices.put(Currencies.US_DOLLAR, priceDollarExTax);
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriceDollarExTax(String priceDollarExTax) {
        this.priceDollarExTax = priceDollarExTax;
    }

    public Product addPrice(Currencies currency, String price) {
        prices.put(currency, price);
        return this;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPriceDollarExTax() {
        return priceDollarExTax;
    }

    public String getPrice(Currencies currency) {
        return prices.get(currency);
    }

    @Override
    public String toString() {
        return "Product [name=" + name 
                + ", description=" + description 
                + ", priceDollarExTax=" + priceDollarExTax
                + ", prices=" + prices + "]";
    }

}
