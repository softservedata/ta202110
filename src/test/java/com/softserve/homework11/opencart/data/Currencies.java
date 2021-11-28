package com.softserve.homework11.opencart.data;

public enum Currencies {
	EURO("Euro"),
	POUND("Pound Sterling"),
	DOLLAR("US Dollar");

	private String name;

	private Currencies(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
