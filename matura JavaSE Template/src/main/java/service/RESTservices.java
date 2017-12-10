package service;

import entity.Student;
import entity.Task;
import entity.Team;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import repository.StudentFacade;
import repository.TaskFacade;
import repository.TeamFacade;

/**
 * REST Web Service
 *
 * @author H. Lackinger
 */

@Path("rest")
public class RESTservices {

    StudentFacade studentRepository = new StudentFacade();

    TeamFacade teamRepository = new TeamFacade();

//    TaskFacade taskRepository = new TaskFacade();

    //Creates a new instance of TeamStudentResource
    public RESTservices() {
    }


    /**
     * Echo
     */
    @GET
    @Path("message")
    public String message() {
        return "hello REST !";
    }
    

    /**
     * Initializes database with test data
     */
    @GET
    @Path("init")
    public String initDB() {
        
        // Create teams
        Team t1 = new Team("5AHITM", "152");
        Team t2 = new Team("4BHIF", "E58");
        // Write teams to DB
        //teamRepository.create(t1);
        //teamRepository.create(t2);        

        // Create tasks
        Task ta1 = new Task("Pflichenheft erstellen");
        Task ta2 = new Task("Projektstrukturplan erstellen");
        Task ta3 = new Task("Präsentation");
        // write Tasks to DB
        //taskRepository.create(ta1);
        //taskRepository.create(ta2);
        //taskRepository.create(ta3);
        
        
        // Create students team 1        
        Student s1 = new Student("Anton", "Aigner",'m',t1);
        s1.addTask(ta1);
        s1.addTask(ta2);
        Student s2 = new Student("Berta", "Bauer",'w',t1);
        s2.addTask(ta3);

        //s2.addTask(new Task("Implementierung"));        
        
        // Create students team 2
        Student s3 = new Student("Caesar", "Czerny",'m',t2);
        //s3.addTask(new Task("Video drehen"));
        //s3.addTask(new Task("Doku schreiben")); 
        Student s4 = new Student("Dora", "Deim",'w',t2);
        //s4.addTask(new Task("Folien erstellen"));
        //s4.addTask(new Task("Handbuch schreiben"));
        
        // write students to DB 
        studentRepository.edit(s1);
        studentRepository.edit (s2);
        studentRepository.edit (s3);
        studentRepository.edit (s4);

        return "DB initialized";
    }
    
     /**
     * Find a student by its id
     */
    @GET
    @Path("student/findbyid/{studentId}")
    @Produces("application/json")
    public Student findStudendById(@PathParam("studentId") int studentId) {
        Student student = studentRepository.findStudentById(studentId);

        return student;
    }

     /**
     * Find students of a given team
     */
    @GET
    @Path("student/findbyteam/{teamId}")
    @Produces("application/json")
    public List<Student> findStudentsByTeam(@PathParam("teamId") String teamId) {
        return  studentRepository.findStudentsByTeam(teamId);
    }
    
    /**
     * Insert a new student
     */
    @POST
    @Path("student/insert")
    @Produces("application/text")
    public String insertStudent(Student student) {
        // Einfügen eines Studenten mit team, bei dem das Team bereitsvorhanden ist ??????????????ßß
        studentRepository.edit(student);
        return "student inserted";
    }
    
     /**
     * Delete a student by its id
     */
    @DELETE
    @Path("student/delete/{studentId}")
    @Produces("application/text")
    public String deleteStudent(@PathParam("studentId") int studentId) {
        studentRepository.remove(studentId);
        return "student deleted";
    }
    
    /**
     * Update a student
     */
    @PUT
    @Path("student/update/{studentId}")
    @Produces("application/text")
    public String updateStudent(@PathParam("studentId") int studentId, Student student) {
        student.setId(studentId);
        studentRepository.edit(student);
        return "student updated";
    }
     /**
     * Find all teams
     */
    @GET
    @Path("team/findall")
    @Produces("application/json")
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }    
    

}
