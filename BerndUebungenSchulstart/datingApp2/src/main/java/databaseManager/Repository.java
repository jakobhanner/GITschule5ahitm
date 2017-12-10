/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManager;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jakob
 */
public class Repository {
     
    private static EntityManagerFactory emf; //nur bei JavaSE erforderlich, bei JavaEE ist das das @PersistenceContext
    private static EntityManager em;
    
    public Repository() {
        emf = Persistence.createEntityManagerFactory("datingPU");
        em = emf.createEntityManager();
    }
    
    public String storePerson(Person p) {
        Person findPerson = em.find(Person.class, p);
        String returnString;
        if (findPerson == null){
            em.persist(p);
            returnString = "Person stored on database";
        } else {
            returnString = "Name already in use.";
        }
        return returnString;
    }
    
    public String updatePerson(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return "Person updated.";
    }
    
    public String deletePerson(Person p) {
        em.getTransaction().begin();

        Person findPerson = em.find(Person.class, p);
        String returnString;
        
        if (findPerson != null){
            em.remove(p);
            returnString = "Person deleted";
        } else {
            returnString = "Person not found";
        }
        em.getTransaction().commit();

        return returnString;
    }
}
