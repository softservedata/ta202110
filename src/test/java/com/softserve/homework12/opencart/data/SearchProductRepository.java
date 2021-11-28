package com.softserve.homework12.opencart.data;

public final class SearchProductRepository {

    private SearchProductRepository() {
    }

    public static SearchProduct getDefault() {
        return getMacDollar();
    }
    
    public static SearchProduct getMacEuro() {
        return new SearchProduct("mac", "Desktops", true,
                Currencies.EURO,
                ProductRepository.getMacBook());
    }
    
    public static SearchProduct getMacPoundSterling() {
        return new SearchProduct("mac", "Desktops", true,
                Currencies.POUND,
                ProductRepository.getMacBook());
    }
    
    public static SearchProduct getMacDollar() {
        return new SearchProduct("mac", "Desktops", true,
                Currencies.DOLLAR,
                ProductRepository.getMacBook());
    }
    
}
