package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Games;


/**
 * This class will provide function for the games class
 * @author levid
 *
 */
public class GamesHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameStore");

	public void insertGame(Games ga) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ga);
		em.getTransaction().commit();
		em.close();
	}

	public List<Games> showAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<Games> allGames = em.createQuery("SELECT g FROM Games g").getResultList();
		return allGames;
	}

	public void deleteGame(Games toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Games> typedQuery = em.createQuery(
				"select ga from Games ga where ga.name = :selectedName",
				Games.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedGame", toDelete.getName());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Games result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Games searchForGameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Games found = em.find(Games.class, idToEdit);
		em.close();
		return found;
	}

	public void updateGame(Games toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
