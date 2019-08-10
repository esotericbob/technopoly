package technopoly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import technopoly.Field;
import technopoly.Player;

class CompanyTest {
	String name;
	boolean isAvailable;
	Player owner;
	Field field;
	int hireVPCost;
	int rent1VP;
	int rent2VP;
	int rent3VP;
	int rentCEO;
	int numVPs;
	int rent;
	int price;
	Company testCompany;
	
	@BeforeEach
	void setUp() throws Exception {
		owner = new Player(1500, "Test Player", 0);
		name = "test company";
		isAvailable = true;
		field = Field.SPACEEXPLORATION;
		hireVPCost = 50;
		rent1VP = 100;
		rent2VP = 200;
		rent3VP = 300;
		rentCEO = 5000;
		numVPs = 2;
		rent = 10;
		price = 1000;
	}

	@Test
	void testSetGetName() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		String expected = name;
		String actual = testCompany.getName();
		assertEquals(expected, actual);
	}
	@Test
	void testSetGetField() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		Field expected = field;
		Field actual = testCompany.getField();
		assertEquals(expected, actual);
	}
	@Test
	void testSetGetOwner() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		Player expected = owner;
		testCompany.setOwner(owner);
		Player actual = testCompany.getOwner();
		assertEquals(expected, actual);
	}
	@Test
	void testSetGetRent() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		int expected = rent;
		int actual = testCompany.getRent();
		assertEquals(expected, actual);
	}
	@Test
	void testSetGetRent1VP() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		int expected = rent1VP;
		int actual = testCompany.getRent1VP();
		assertEquals(expected, actual);
	}@Test
	void testSetGetRent2VP() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		int expected = rent2VP;
		int actual = testCompany.getRent2VP();
		assertEquals(expected, actual);
	}@Test
	void testSetGetRent3VP() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		int expected = rent3VP;
		int actual = testCompany.getRent3VP();
		assertEquals(expected, actual);
	}@Test
	void testSetGetRentCEO() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		int expected = rentCEO;
		int actual = testCompany.getRentCEO();
		assertEquals(expected, actual);
	}
	@Test
	void testSetGetPrice() {
		testCompany = new Company(name, field, hireVPCost, rent1VP, rent2VP, rent3VP, rentCEO, numVPs, rent, price);
		int expected = price;
		int actual = testCompany.getPrice();
		assertEquals(expected, actual);
	}
}
