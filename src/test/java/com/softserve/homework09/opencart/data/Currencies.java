package com.softserve.homework09.opencart.data;

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
