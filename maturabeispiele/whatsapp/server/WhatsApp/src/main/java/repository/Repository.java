/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ChatGroup;
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

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("whatsappPU");
    private static EntityManager em = emf.createEntityManager();

    public void init() {
        Person p1 = new Person("Jakob", "asdf");
        Person p2 = new Person("Bernd", "asdf");
        Person p3 = new Person("Bernhard", "asdf");
        Person p4 = new Person("Roman", "asdf");

        ChatGroup g1 = new ChatGroup("RoadAdventure");
        ChatGroup g2 = new ChatGroup("Umzug");

        g1.addListener(p1);
        g1.addListener(p2);
        g1.addListener(p3);
        g1.addListener(p4);

        g2.addListener(p1);
        g2.addListener(p2);

        em.persist(g1);
        em.persist(g2);
        
        System.out.println("DB initialized.");
    }

    public List<ChatGroup> getGroupsByUsername(String username) {
        List<ChatGroup> allGroups = findAllGroups();
        List<ChatGroup> groups = new ArrayList<>();

        for (ChatGroup g:allGroups){
            for(Person p:g.getListener()){
                if(p.getUsername().equals(username)){
                    groups.add(g);
                    System.out.println("Username Group: " + g.toString());
                }
            }
        }

        return groups;
    }

    public List<ChatGroup> findAllGroups() {
        return this.em.createNamedQuery("Group.findAll", ChatGroup.class).getResultList();
    }
}
