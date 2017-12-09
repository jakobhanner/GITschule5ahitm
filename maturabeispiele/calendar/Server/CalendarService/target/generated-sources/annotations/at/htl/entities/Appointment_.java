package at.htl.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Appointment.class)
public abstract class Appointment_ {

	public static volatile SingularAttribute<Appointment, LocalDate> date;
	public static volatile SingularAttribute<Appointment, Calendar> calendar;
	public static volatile SingularAttribute<Appointment, String> description;
	public static volatile SingularAttribute<Appointment, Long> id;
	public static volatile SingularAttribute<Appointment, LocalTime> time;

}

