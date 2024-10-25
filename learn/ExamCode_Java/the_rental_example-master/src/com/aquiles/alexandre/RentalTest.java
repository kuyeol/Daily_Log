package com.aquiles.alexandre;


import org.junit.Assert;
import org.junit.Test;

public class RentalTest {
	
	@Test
	public void shortRegularRental() {
		Customer customer = createCustomer();
		addRental(customer, "Groundhog Day", Movie.REGULAR, 2);

		String expected = "Rental record for Luke\n";
		expected += "\tGroundhog Day\t2.0\n";
		expected += "Amount owed is 2.0\n";
		expected += "You earned 1 frequent renter points";

		Assert.assertEquals(expected, customer.statement());
	} 

	@Test
	public void longRegularRental() {
		Customer customer = createCustomer();
		addRental(customer, "Groundhog Day", Movie.REGULAR, 3);

		String expected = "Rental record for Luke\n";
		expected += "\tGroundhog Day\t3.5\n";
		expected += "Amount owed is 3.5\n";
		expected += "You earned 1 frequent renter points";

		Assert.assertEquals(expected, customer.statement());
	} 

	@Test
	public void shortNewReleaseRental() {
		Customer customer = createCustomer();
		addRental(customer, "X-Men X", Movie.NEW_RELEASE, 1);
		
		String expected = "Rental record for Luke\n";
		expected += "\tX-Men X\t3.0\n";
		expected += "Amount owed is 3.0\n";
		expected += "You earned 1 frequent renter points";
		
		Assert.assertEquals(expected, customer.statement());
	} 

	@Test
	public void longNewReleaseRental() {
		Customer customer = createCustomer();
		addRental(customer, "X-Men X", Movie.NEW_RELEASE, 2);

		String expected = "Rental record for Luke\n";
		expected += "\tX-Men X\t6.0\n";
		expected += "Amount owed is 6.0\n";
		expected += "You earned 2 frequent renter points";
		
		Assert.assertEquals(expected, customer.statement());
	} 

	@Test
	public void shortChildrensRental() {
		Customer customer = createCustomer();
		addRental(customer, "Toy Story", Movie.CHILDRENS, 3);

		String expected = "Rental record for Luke\n";
		expected += "\tToy Story\t1.5\n";
		expected += "Amount owed is 1.5\n";
		expected += "You earned 1 frequent renter points";

		Assert.assertEquals(expected, customer.statement());
	} 

	@Test
	public void longChildrensRental() {
		Customer customer = createCustomer();
		addRental(customer, "Toy Story", Movie.CHILDRENS, 4);

		String expected = "Rental record for Luke\n";
		expected += "\tToy Story\t3.0\n";
		expected += "Amount owed is 3.0\n";
		expected += "You earned 1 frequent renter points";

		Assert.assertEquals(expected, customer.statement());
	}

	@Test
	public void variousRentals() {
		Customer customer = createCustomer();
		addRental(customer, "Groundhog Day", Movie.REGULAR, 3);
		addRental(customer, "X-Men X", Movie.NEW_RELEASE, 2);
		addRental(customer, "Toy Story", Movie.CHILDRENS, 4);

		String expected = "Rental record for Luke\n";
		expected += "\tGroundhog Day\t3.5\n";
		expected += "\tX-Men X\t6.0\n";
		expected += "\tToy Story\t3.0\n";
		expected += "Amount owed is 12.5\n";
		expected += "You earned 4 frequent renter points";

		Assert.assertEquals(expected, customer.statement());
	} 
	
	@Test
	public void variousRentalsInHTML() {
		Customer customer = createCustomer();
		addRental(customer, "Groundhog Day", Movie.REGULAR, 3);
		addRental(customer, "X-Men X", Movie.NEW_RELEASE, 2);
		addRental(customer, "Toy Story", Movie.CHILDRENS, 4);

		String expected = "<P><H1>Rentals for <EM>Luke</EM></H1></P>\n";
		expected += "<P>Groundhog Day: 3.5</P>\n";
		expected += "<P>X-Men X: 6.0</P>\n";
		expected += "<P>Toy Story: 3.0</P>\n";
		expected += "<P>You owe <EM>12.5</EM></P>\n";
		expected += "<P>On this rental you earned <EM>4</EM> frequent renter points</P>";

		Assert.assertEquals(expected, customer.statementAsHTML());
	} 

	private Customer createCustomer(){
		return new Customer("Luke");
	}

	private void addRental(Customer customer, String movieName, Integer priceCode, Integer daysRented) {
		Movie movie = new Movie(movieName, priceCode);
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
	} 

}
