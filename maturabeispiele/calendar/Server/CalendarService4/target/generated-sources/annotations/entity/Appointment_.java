package entity;

import entity.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T19:33:41")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, LocalTime> lTime;
    public static volatile SingularAttribute<Appointment, Calendar> calendar;
    public static volatile SingularAttribute<Appointment, LocalDate> lDate;
    public static volatile SingularAttribute<Appointment, String> description;
    public static volatile SingularAttribute<Appointment, Long> id;

}