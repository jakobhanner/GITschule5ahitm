/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Appointment;
import entity.Calendar;
import java.util.List;

/**
 *
 * @author Jakob Hanner
 */
public class AppointmentFacade extends AbstractFacade<Appointment> {
    
    public AppointmentFacade() {
        super(Appointment.class);
    }
    public List<Appointment> getAppByCal(Calendar c){
       return this.em.createNamedQuery("Appointment.findByCalender").setParameter("calendar", c).getResultList();
    }
}
