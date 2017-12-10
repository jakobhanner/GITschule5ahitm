/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Calendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jakob
 */
@Stateless
public class CalendarFacade extends AbstractFacade<Calendar> {

    @PersistenceContext(unitName = "CalendarService_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalendarFacade() {
        super(Calendar.class);
    }
    
}
