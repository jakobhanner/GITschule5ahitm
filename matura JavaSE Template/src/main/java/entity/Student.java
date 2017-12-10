package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author H. Lackinger
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findByTeam", query = "SELECT s FROM Student s WHERE s.team.teamId = :teamId ")
})
//@XmlRootElement
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@XmlElement(name="studentId")
    private int id;
    //@XmlElement (name="vorname")
    private String firstName;
    private String lastName;
    private char   sex;
    private String street;
    private String city;
    private String zip;
    
    private LocalDateTime birthDay;
    private int    weight;
    private int    height;
    
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Team team;
    
    @OneToMany (fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
//    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks= new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, char sex, Team t) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.team = t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    
    
    
    
    //-------------------------------------------------
    public void addTask(Task task) {
        this.tasks.add(task);
    }
    
    
}
