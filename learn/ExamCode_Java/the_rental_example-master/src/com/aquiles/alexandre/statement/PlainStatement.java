package com.aquiles.alexandre.statement;

import com.aquiles.alexandre.Customer;
import com.aquiles.alexandre.Rental;

public class PlainStatement extends Statement {

	public PlainStatement(Customer customer) {
		super(customer);
	}

	@Override
	protected String footer() {
		return "Amount owed is " + String.valueOf(getCustomer().getTotalCharge()) + "\n" + "You earned " + String.valueOf(getCustomer().getTotalFrequentRenterPoints()) + " frequent renter points";
	}

	@Override
	protected String detail(Rental rental) {
		return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
	}

	@Override
	protected String header() {
		return "Rental record for " + getCustomer().getName() + "\n";
	}

}
