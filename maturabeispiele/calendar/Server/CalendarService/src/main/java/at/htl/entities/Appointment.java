/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htl.entities;

import java.time.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jakob
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Appointment.findByDate", query="SELECT a FROM Appointment a WHERE a.date = :date AND calendar = :calendar ORDER BY time"),
    @NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
})
public class Appointment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String description;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne(cascade=CascadeType.MERGE)
    private Calendar calendar;
    
    public Appointment() {
    }

    public Appointment(long id, String description, LocalDate date, LocalTime time, Calendar calendar) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.time = time;
        this.calendar = calendar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    
    
    
}
