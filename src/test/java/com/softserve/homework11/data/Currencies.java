package com.softserve.homework11.data;


public enum Currencies {
    DEFAULT_CURRENCY("US Dollar"),
    EURO("Euro"),
    POUND_STERLING("Pound Sterling"),
    US_DOLLAR("US Dollar");
    //
    private String name;

    private Currencies(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
