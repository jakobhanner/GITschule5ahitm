/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Group;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jakob Hanner
 */
public class Repository {

    public Repository() {
    }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("person");
    private static EntityManager em = emf.createEntityManager();

    public void init() {
        Person p1 = new Person("Jakob", "asdf");
        Person p2 = new Person("Bernd", "asdf");
        Person p3 = new Person("Bernhard", "asdf");
        Person p4 = new Person("Roman", "asdf");

        Group g1 = new Group("RoadAdventure");
        Group g2 = new Group("Umzug");

        g1.addListener(p1);
        g1.addListener(p2);
        g1.addListener(p3);
        g1.addListener(p4);

        g2.addListener(p1);
        g2.addListener(p2);

        em.persist(g1);
        em.persist(g2);
    }

    public List<Group> getGroupsByUsername(String username) {
        List<Group> allGroups = findAllGroups();
        List<Group> groups = new ArrayList<>();

        for (Group g:allGroups){
            for(Person p:g.getListener()){
                if(p.getUsername().equals(username)){
                    groups.add(g);
                }
            }
        }

        return groups;
    }

    public List<Group> findAllGroups() {
        return this.em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }
}
