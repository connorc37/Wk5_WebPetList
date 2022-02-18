package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pet;

/**
 * @author Corey Connor - cconnor3
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */

public class PetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk5_WebPetList");

	public void addPet(Pet toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deletePet(Pet toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.type = :selectedType and p.name = :selectedName and p.owner = :selectedOwner", Pet.class);
		
		// Provide data for the parameters above.
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		
		// One result.
		typedQuery.setMaxResults(1);
		
		// Save the result into a new Pet object.
		Pet result = typedQuery.getSingleResult();
		
		// Remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Pet searchForPetById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Pet found = em.find(Pet.class, idToEdit);
		em.close();
		return found;
	}

	public List<Pet> searchForPetByType(String type) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.type = :selectedType", Pet.class);
		
		typedQuery.setParameter("selectedType", type);
		
		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}

	public List<Pet> searchForPetByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.name = :selectedName", Pet.class);
		
		typedQuery.setParameter("selectedName", name);
		
		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}

	public List<Pet> searchForPetByOwner(String owner) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.owner = :selectedOwner", Pet.class);
		
		typedQuery.setParameter("selectedOwner", owner);
		
		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}

	public void updatePet(Pet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Pet> showAllPets() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<Pet> allPets = em.createQuery("SELECT i FROM Pet i").getResultList();
		return	allPets;
	}

	public void cleanUp() {
		emfactory.close();
	}

}