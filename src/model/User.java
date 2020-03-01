package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * This class will provide a template for a user
 * @author levid
 *
 *Thomas Morrissey
 *3/1 8:30am - set as entity and referenced database
 *			 - added join table(third table on database called games_owned)
 *			 - added constructors
 */
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USERNAME")
	private String username;
	@Column(name="CREATE_DATE")
	private LocalDate create_date;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
				//references table that will be the between table in the database
				name="GAMES_OWNED",
				joinColumns= { @JoinColumn(name="USER_ID", referencedColumnName="USER_ID") },
				inverseJoinColumns= { @JoinColumn(name="GAME_ID", referencedColumnName="GAME_ID", unique=true) }	
		)
		//will be where games owned by user will be store, so they may be displayed
		private List<Games> gamesOwned;
	
	
	
	/**
	 * Default no-arg constructor
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String username, LocalDate create_date, List<Games> games_owned) {
		super();
		this.userId = userId;
		this.username = username;
		this.create_date = create_date;
		this.gamesOwned = games_owned;
	}
	
	public User(String username, LocalDate create_date, List<Games> games_owned) {
		super();
		this.username = username;
		this.create_date = create_date;
		this.gamesOwned = games_owned;
	}
	
	public User(String username, LocalDate create_date) {
		super();
		this.username = username;
		this.create_date = create_date;
	}

	/**
	 * Getters and Setters
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDate create_date) {
		this.create_date = create_date;
	}
	
	public List<Games> getGamesOwned() {
		return gamesOwned;
	}

	public void setGamesOwned(List<Games> gamesOwned) {
		this.gamesOwned = gamesOwned;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", create_date=" + create_date + ", gamesOwned="
				+ gamesOwned + "]";
	}

	/**
	 * End of Getters and Setters
	 */
	

	
}
