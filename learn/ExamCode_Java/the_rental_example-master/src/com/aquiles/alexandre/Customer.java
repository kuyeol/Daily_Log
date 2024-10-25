package com.aquiles.alexandre;

import java.util.ArrayList;
import java.util.Collection;

import com.aquiles.alexandre.statement.Statement;

public class Customer {
	
	private String name;
	private Collection<Rental> rentals;
	
	public Customer(String name) {
		super();
		rentals = new ArrayList<Rental>();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void addRental(Rental rental) {
		getRentals().add(rental);
	}

	public String statement() {
		return Statement.plainStatement(this).generateStatement();
	}

	public String statementAsHTML() {
		return Statement.htmlStatement(this).generateStatement();
	}

	public Integer getTotalFrequentRenterPoints() {
		Integer totalFrequentRenterPoints = 0;
		for(Rental rental : getRentals()) {
			totalFrequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return totalFrequentRenterPoints;
	}

	public Double getTotalCharge() {
		Double totalAmount = 0.0;
		for(Rental rental : getRentals()) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

	public Collection<Rental> getRentals() {
		return rentals;
	}

}

	
	