package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Jakob
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Student.findByTeam", query="SELECT s FROM Student s WHERE s.team.teamId = :teamId"),
    @NamedQuery(name="Student.findAllStudents", query="SELECT s FROM Student s")

})
public class Student implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String firstName;
    private String lastName;
    private double weight;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Team team;
    
    //Fetch Eager = gleich alle Daten mitladen
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Task> tasks = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, double weight, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.team = team;
    }

    public Student(String firstname, String lastname, double weight) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.weight = weight;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task tk1) {
        this.tasks.add(tk1);
    }
    
    
    
}
