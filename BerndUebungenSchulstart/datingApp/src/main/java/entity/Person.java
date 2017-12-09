package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;
    
    private String name;
    private int age;
    private String status;
    
    List<Person> lovers;

    public Person() {
    }

    public Person(String name, int age, String status, List<Person> lovers) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.lovers = lovers;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Person> getLovers() {
        return lovers;
    }

    public void setLovers(List<Person> lovers) {
        this.lovers = lovers;
    }
   
    
    
}
