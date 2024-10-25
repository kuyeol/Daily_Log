package com.aquiles.alexandre;

import com.aquiles.alexandre.pricing.ChildrensPrice;
import com.aquiles.alexandre.pricing.NewReleasePrice;
import com.aquiles.alexandre.pricing.Price;
import com.aquiles.alexandre.pricing.RegularPrice;

public class Movie {

	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private String title;
	private Price price;
	
	public Movie(String title, Integer priceCode) {
		super();
		this.title = title;
		setPriceCode(priceCode);
	}

	public Integer getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(Integer priceCode) {
		switch(priceCode) {
		case Movie.REGULAR:
			price = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			price = new ChildrensPrice();
			break;
		default:
			throw new IllegalArgumentException("Invalid price code.");
			
		}
	}

	public String getTitle() {
		return title;
	}

	public Double getCharge(Integer daysRented) {
		return price.getCharge(daysRented);
	}

	public Integer getFrequentRenterPoints(Integer daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
	
	
	
}
