/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jakob
 */
@XmlRootElement
public class AppointmentDto {

    private long id;
    private String description, date, time;
    private long calendarId;

    public AppointmentDto() {
    }

    public AppointmentDto(long id, String description, String date, String time, long calendarId) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.time = time;
        this.calendarId = calendarId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(long calendarId) {
        this.calendarId = calendarId;
    }
    
    
}
