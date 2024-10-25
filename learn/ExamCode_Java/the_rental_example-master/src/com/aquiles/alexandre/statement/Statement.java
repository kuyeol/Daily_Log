package com.aquiles.alexandre.statement;

import com.aquiles.alexandre.Customer;
import com.aquiles.alexandre.Rental;


public abstract class Statement {
	
	private Customer customer;
	
	Statement(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public String generateStatement(){
		String result = header();
		for(Rental rental : getCustomer().getRentals()) {
			//show figures for this rental
			result += detail(rental);
		}
		
		//add footer lines
		result += footer();
		return result;
	}
	
	public static Statement plainStatement(Customer customer) {
		return new PlainStatement(customer);
	}

	public static Statement htmlStatement(Customer customer) {
		return new HtmlStatement(customer);
	}
	protected abstract String footer();

	protected abstract String detail(Rental rental);

	protected abstract String header();

}
