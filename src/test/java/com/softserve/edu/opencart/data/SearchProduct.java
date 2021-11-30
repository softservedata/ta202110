package com.softserve.edu.opencart.data;

public class SearchProduct {

    private String searchText;
    private String category; // Create Enum
    private boolean searchInSubcategories;
    //private boolean searchInDescriptions;
    //
    private Currencies currency;
    private Product product;

    // TODO add Builder
    public SearchProduct(String searchText, String category,
            boolean searchInSubcategories, Currencies currency,
            Product product) {
        this.searchText = searchText;
        this.category = category;
        this.searchInSubcategories = searchInSubcategories;
        this.currency = currency;
        this.product = product;
    }

    // setters
    
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSearchInSubcategories(boolean searchInSubcategories) {
        this.searchInSubcategories = searchInSubcategories;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    // getters
    
    public String getSearchText() {
        return searchText;
    }

    public String getCategory() {
        return category;
    }

    public boolean isSearchInSubcategories() {
        return searchInSubcategories;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public Product getProduct() {
        return product;
    }
    
    public String getPrice() {
        return getProduct().getPrice(getCurrency());
    }

    @Override
    public String toString() {
        return "SearchProduct [searchText=" + searchText
                + ", category=" + category 
                + ", searchInSubcategories=" + searchInSubcategories
                + ", currency=" + currency.toString()
                + ", product=" + product.toString() + "]";
    }
    
}
