package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Integer> studentId;
	public static volatile SingularAttribute<Student, String> firstName;
	public static volatile SingularAttribute<Student, String> lastName;
	public static volatile SingularAttribute<Student, Double> weight;
	public static volatile SingularAttribute<Student, Team> team;
	public static volatile ListAttribute<Student, Task> tasks;

}

