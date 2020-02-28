package model;

import java.time.LocalDate;


/**
 * This class will provide a template for a user
 * @author levid
 *
 */
public class User {

	private int id;
	private LocalDate create_date;
	
	/**
	 * Default no-arg constructor
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDate create_date) {
		this.create_date = create_date;
	}
	/**
	 * End of Getters and Setters
	 */

	@Override
	public String toString() {
		return "User [id=" + id + ", create_date=" + create_date + "]";
	}
}
