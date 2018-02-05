/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jakob Hanner
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ppiPU");
    protected static EntityManager em = emf.createEntityManager();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void create(T entity) {
        em.getTransaction().begin();
        getEntityManager().persist(entity);
        em.getTransaction().commit();
    }

    public void edit(T entity) {
        em.getTransaction().begin();
        getEntityManager().merge(entity);
        em.getTransaction().commit();
    }

    public void remove(T entity) {
        em.getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        em.getTransaction().commit();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq
                = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
