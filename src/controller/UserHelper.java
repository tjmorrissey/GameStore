package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Games;
import model.User;

/**
 * This class will provide function for the user class
 * @author levid
 *
 */
public class UserHelper {

	//entity manager, can be used by all methods in class
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameStore");
	
	//used to insert new user into the database
	public void insertNewUser(User s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	//will return all users from database
	public List<Games> getUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<Games> allUsers = em.createQuery("SELECT u FROM User u").getResultList();
		return allUsers;
	}
	
}
