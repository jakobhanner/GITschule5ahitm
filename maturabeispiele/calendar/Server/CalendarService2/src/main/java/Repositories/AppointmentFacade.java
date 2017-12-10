/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Appointment;
import Entities.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jakob
 */
@Stateless
public class AppointmentFacade extends AbstractFacade<Appointment> {

    @PersistenceContext(unitName = "CalendarService_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppointmentFacade() {
        super(Appointment.class);
    }
    public List<Appointment> getAppByCal(Calendar c){
       return this.em.createNamedQuery("Appointment.findByCalender").setParameter("calendar", c).getResultList();
    }
    
}
