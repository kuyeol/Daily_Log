package com.aquiles.alexandre.pricing;

public abstract class Price {

	public abstract Integer getPriceCode();

	public abstract Double getCharge(Integer daysRented);

	public Integer getFrequentRenterPoints(Integer daysRented) {
		return 1;
	}
}
