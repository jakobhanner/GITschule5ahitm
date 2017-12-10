package at.htl.calendarservice;

import at.htl.entities.Appointment;
import at.htl.entities.Calendar;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jakob
 */
public class AppointmentRepository extends AbstractFacade<Appointment>{

    @PersistenceContext(unitName="PU_Calendar")
    private EntityManager em;

    public AppointmentRepository() {
        super(Appointment.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Appointment> findByDate(LocalDate date, long calendarid){
        Calendar c = em.find(Calendar.class, calendarid);
        return em.createNamedQuery("Appointment.findByDate")
                .setParameter("date", date)
                .setParameter("calendar", c)
                .getResultList();
    }
    
    public List<Appointment> findAll(){
        return em.createNamedQuery("Appointment.findAll").getResultList();
    }
}
