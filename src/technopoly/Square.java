package technopoly;
/**
 * Group 4 Technolpoly Sci-fi Conglomerate edition
 * @author Andy McCollum, Neil Gray, Jay hanna, Jonathan Smyth
 * @version 1.0.0
 * 
 */
public abstract class Square {
	private String name;
	private boolean isAvailable;
	private Player owner;
	
	public Square(String name, boolean isAvailable) {
		this.name = name;
		this.isAvailable = isAvailable;
	}
	public Square(String name, boolean isAvailable, Player owner) {
		this.name = name;
		this.isAvailable = isAvailable;
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Square [name=" + name + ", isAvailable=" + isAvailable + ", owner=" + owner + "]";
	}	
}
