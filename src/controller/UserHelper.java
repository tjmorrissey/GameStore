package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	public List<User> getAllUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT u FROM User u").getResultList();
		return allUsers;
	}
	
	public void deleteUser(User toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery(
				"select li from User li where li.username = :selectedUsername",
				User.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedUsername", toDelete.getUsername());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		User result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public User searchForUserById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		User found = em.find(User.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateUser(User toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> searchForUserByStore(String storeUsername) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select li from User li where li.username = :selectedUsername", User.class);
		typedQuery.setParameter("selectedUsername", storeUsername);

		List<User> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
