package model;


/**
 * This class will provide a template for games
 * @author levid
 *
 */
public class Games {

	private String name;
	private double price;
	
	/**
	 * Default no-arg constructor
	 */
	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * End of Getters and Setters
	 */

	@Override
	public String toString() {
		return "Games [name=" + name + ", price=" + price + "]";
	}
	
}
