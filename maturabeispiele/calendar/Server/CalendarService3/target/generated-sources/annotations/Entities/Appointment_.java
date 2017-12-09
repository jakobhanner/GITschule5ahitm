package Entities;

import Entities.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T12:40:38")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, LocalDate> date;
    public static volatile SingularAttribute<Appointment, Calendar> calendar;
    public static volatile SingularAttribute<Appointment, String> description;
    public static volatile SingularAttribute<Appointment, Long> id;
    public static volatile SingularAttribute<Appointment, LocalTime> time;

}