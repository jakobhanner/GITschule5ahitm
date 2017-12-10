/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jakob
 */
@Entity
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private LocalDate lDate;
    private LocalTime lTime;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Calendar calendar;

    public Appointment() {
    }

    public Appointment(String description, LocalDate lDate, LocalTime lTime) {
        this.description = description;
        this.lDate = lDate;
        this.lTime = lTime;
    }

    public Appointment(String description, LocalDate lDate, LocalTime lTime, Calendar calendar) {
        this.description = description;
        this.lDate = lDate;
        this.lTime = lTime;
        this.calendar = calendar;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getlDate() {
        return lDate;
    }

    public void setlDate(LocalDate lDate) {
        this.lDate = lDate;
    }

    public LocalTime getlTime() {
        return lTime;
    }

    public void setlTime(LocalTime lTime) {
        this.lTime = lTime;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    
}
