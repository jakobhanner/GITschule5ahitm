/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jakob Hanner
 */
public abstract class AbstractFacade<T> {
    
    private Class<T> entityClass;
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamStudentTaskPU");
    protected static EntityManager em = emf.createEntityManager();
}
