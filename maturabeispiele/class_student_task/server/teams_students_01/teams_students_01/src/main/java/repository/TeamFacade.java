/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Team;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jakob
 */
@Stateless
public class TeamFacade extends AbstractFacade<Team> {

    @PersistenceContext(unitName = "htl_teamsstudents")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamFacade() {
        super(Team.class);
    }

    public Team findTeamById(String teamId) {
        return em.find(Team.class, teamId);
    }

    public List<Team> findTeams() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }

    public void deleteTeamByName(String teamName) {
        Team t = em.find(Team.class, teamName);
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }
    
}
