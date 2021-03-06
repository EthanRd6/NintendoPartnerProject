package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Games;

/**
* @author Ethan Dorenkamp - edorenkamp
* CIS175 - Spring 2021
* Mar 5, 2021
*/
public class GamesHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NintendoPartnerProject");
	
	public void addGame(Games g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Games> showAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<Games> allItems = em.createQuery("SELECT i FROM Games i").getResultList();
		return allItems;
	}
	
	public void deleteGame(Games toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Games> typedQuery = em.createQuery("select g from"
+ " Games g where g.name = :selectedName and g.year = :selectedYear"
+ " and g.type = :selectedType and g.numPlayers = :selectedNumPlayers", Games.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedNumPlayers", toDelete.getNumPlayers());
		
		typedQuery.setMaxResults(1);
		
		Games result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Games searchForGameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Games found = em.find(Games.class, idToEdit);
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
	
	public List<Games> searchForGameByName(String gameName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Games> typedQuery = em.createQuery("select g from Games g where "
				+ "g games.name = :selectedName", Games.class);
		typedQuery.setParameter("selectedName", gameName);
		
		List<Games> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
	}
}
