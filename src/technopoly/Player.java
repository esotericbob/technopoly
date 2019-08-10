package technopoly;

import java.util.ArrayList;
/**
 * Group 4 Technolpoly Sci-fi Conglomerate edition
 * @author Andy McCollum, Neil Gray, Jay hanna, Jonathan Smyth
 * @version 1.0.0
 * 
 */
public class Player {
	private int credits;
	private String gamertag;
	private int position;
	private ArrayList<Company> companies;
	
	
	public Player(int credits, String gamertag, int position) {
		super();
		this.credits = credits;
		this.gamertag = gamertag;
		this.position = position;
		this.companies = new ArrayList<Company>();
	}
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getGamertag() {
		return gamertag;
	}
	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	
	public void setOwnsCompany(Company company) {
		this.companies.add(company);
	}
	
	public void showBalance() {
		System.out.println(this.getGamertag() + " Balance: " + this.getCredits() + " credits");
	}
	
	public boolean isBankrupt() {
		if (credits < 0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return gamertag + " [Balance: "+ credits + "]";
	}
	

}
