package technopoly;
/**
 * Group 4 Technolpoly Sci-fi Conglomerate edition
 * @author Andy McCollum, Neil Gray, Jay hanna, Jonathan Smyth
 * @version 1.0.0
 * 
 */
public class Company extends Square{
	private Field field;
	private int hireVPCost;
	private int rent1VP;
	private int rent2VP;
	private int rent3VP;
	private int rentCEO;
	private int numVPs;
	private int rent;
	private int price;
	
	public Company(String name, Field field, int hireVPCost, int rent1vp, int rent2vp, int rent3vp, int rentCEO, int numVPs,
			int rent, int price) {
		super(name, true);
		//this.setName(name);
		this.field = field;
		this.hireVPCost = hireVPCost;
		rent1VP = rent1vp;
		rent2VP = rent2vp;
		rent3VP = rent3vp;
		this.rentCEO = rentCEO;
		this.numVPs = numVPs;
		this.rent = rent;
		this.price = price;
	}
	
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public int getHireVPCost() {
		return hireVPCost;
	}
	public void setHireVPCost(int hireVPCost) {
		this.hireVPCost = hireVPCost;
	}
	public int getRent1VP() {
		return rent1VP;
	}
	public void setRent1VP(int rent1vp) {
		rent1VP = rent1vp;
	}
	public int getRent2VP() {
		return rent2VP;
	}
	public void setRent2VP(int rent2vp) {
		rent2VP = rent2vp;
	}
	public int getRent3VP() {
		return rent3VP;
	}
	public void setRent3VP(int rent3vp) {
		rent3VP = rent3vp;
	}
	public int getRentCEO() {
		return rentCEO;
	}
	public void setRentCEO(int rentCEO) {
		this.rentCEO = rentCEO;
	}
	public int getNumVPs() {
		return numVPs;
	}
	public void setNumVPs(int numVPs) {
		this.numVPs = numVPs;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Company [name=" + this.getName() + " field=" + field + ", hireVPCost=" + hireVPCost + ", rent1VP=" + rent1VP + ", rent2VP="
				+ rent2VP + ", rent3VP=" + rent3VP + ", rentCEO=" + rentCEO + ", numVPs=" + numVPs + ", rent=" + rent
				+ ", price=" + price + "]";
	}
	
	
}
