package com.aquiles.alexandre;


public class Rental {

	private Movie movie;
	private Integer daysRented;
	
	public Rental(Movie movie, Integer daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public Integer getDaysRented() {
		return daysRented;
	}

	public Double getCharge() {
		return getMovie().getCharge(getDaysRented());
	}
	
	public Integer getFrequentRenterPoints() {
		return getMovie().getFrequentRenterPoints(getDaysRented());
	}

	
}
