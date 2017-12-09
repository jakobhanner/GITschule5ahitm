/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Appointment;
import Entities.AppointmentDto;
import Entities.Calendar;
import Repositories.AppointmentFacade;
import Repositories.CalendarFacade;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jakob
 */
@Path("rest")
public class GenericResource {

    @Context
    private UriInfo context;
    @Inject
    private CalendarFacade cf;
    @Inject
    private AppointmentFacade af;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of Service.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    //  @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        return "Hallo!";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(AppointmentDto entity) {
        this.af.create(fromDto(entity));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void edit(@PathParam("id") long id, AppointmentDto a) {
        Appointment app = fromDto(a);
        app.setId(id);
        this.af.edit(app);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") long id) {
        this.af.remove(this.af.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAll")
    public List<AppointmentDto> findAll() {
        return this.af.findAll().stream()
                .map(a -> toDto(a))
                .collect(Collectors.toList());
    }

    @GET
    @Path("init")
    public String initDB() {
        Calendar calender = new Calendar("Kalender");
        Appointment a1 = new Appointment("Essen", LocalDate.now(), LocalTime.MIDNIGHT);
        a1.setCalendar(calender);
        Appointment a2 = new Appointment("Essen", LocalDate.now(), LocalTime.now());
        a2.setCalendar(calender);
        cf.create(calender);
        af.create(a1);
        af.create(a2);
        return "DB init";
    }

    @GET
    @Path("find/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AppointmentDto getAppointment(@PathParam("id") long id) {
        return toDto(this.af.find(id));
    }
    
    @GET
    @Path("findCalendar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calendar> findCalendar(){
        return this.cf.findAll();
    }
    
    @GET
    @Path("getAppOfCal/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<AppointmentDto> getAppOfCal(@PathParam("id") long id){
        Calendar c = this.cf.find(id);
        return this.af.getAppByCal(c).stream()
                .map(a -> toDto(a))
                .collect(Collectors.toList());
    }

    private AppointmentDto toDto(Appointment a) {
        return new AppointmentDto(a.getId(),
                a.getDescription(),
                a.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                a.getTime().format(DateTimeFormatter.ofPattern("hh:mm")),
                a.getCalendar().getId());
    }

    private Appointment fromDto(AppointmentDto a) {
        return new Appointment(a.getId(),
                a.getDescription(),
                LocalDate.parse(a.getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalTime.parse(a.getTime(), DateTimeFormatter.ofPattern("hh:mm")),
                cf.find(a.getCalendarId()));
    }

}
