package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class will provide a template for games
 * @author levid
 *
 *Thomas Morrissey
 *3/1 8:30am - set as entity and referenced database
 *			 - added GAME_ID, tried to keep consistent naming convention
 */
@Entity
@Table(name="games")
public class Games {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GAME_ID")
	private int gameId;
	@Column(name="GAME_ID")
	private String name;
	@Column(name="GAME_ID")
	private double price;
	
	/**
	 * Default no-arg constructor
	 */
	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Games(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}



	/**
	 * Getters and Setters
	 */
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}	
	
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
		return "Games [gameId=" + gameId + ", name=" + name + ", price=" + price + "]";
	}
	
}
