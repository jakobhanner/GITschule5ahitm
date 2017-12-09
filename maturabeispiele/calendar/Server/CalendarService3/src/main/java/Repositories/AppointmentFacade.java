/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Appointment;
import Entities.Calendar;
import java.util.List;

/**
 *
 * @author Jakob
 */
public class AppointmentFacade extends AbstractFacade<Appointment> {

    public AppointmentFacade() {
        super(Appointment.class);
    }
    public List<Appointment> getAppByCal(Calendar c){
       return this.em.createNamedQuery("Appointment.findByCalender").setParameter("calendar", c).getResultList();
    }
    
}
