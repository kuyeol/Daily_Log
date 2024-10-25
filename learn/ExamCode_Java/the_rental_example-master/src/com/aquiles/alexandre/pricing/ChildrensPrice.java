package com.aquiles.alexandre.pricing;

import com.aquiles.alexandre.Movie;

public class ChildrensPrice extends Price {

	@Override
	public Integer getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	public Double getCharge(Integer daysRented) {
		Double result = 1.5;
		if(daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}
}
