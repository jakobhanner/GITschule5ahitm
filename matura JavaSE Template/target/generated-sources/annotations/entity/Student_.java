package entity;

import entity.Task;
import entity.Team;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-10-06T09:40:33")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> zip;
    public static volatile SingularAttribute<Student, String> firstName;
    public static volatile SingularAttribute<Student, String> lastName;
    public static volatile SingularAttribute<Student, LocalDateTime> birthDay;
    public static volatile SingularAttribute<Student, String> city;
    public static volatile SingularAttribute<Student, String> street;
    public static volatile SingularAttribute<Student, Character> sex;
    public static volatile SingularAttribute<Student, Integer> weight;
    public static volatile SingularAttribute<Student, Integer> id;
    public static volatile SingularAttribute<Student, Team> team;
    public static volatile ListAttribute<Student, Task> tasks;
    public static volatile SingularAttribute<Student, Integer> height;

}