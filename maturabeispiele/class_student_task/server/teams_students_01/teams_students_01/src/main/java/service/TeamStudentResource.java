/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Student;
import entity.Task;
import entity.Team;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import repository.*;

/**
 * REST Web Service
 *
 * @author Jakob
 */
@Stateless
@Path("rest")
public class TeamStudentResource {

    @Inject
    StudentFacade studentRepository;

    @Inject
    TaskFacade taskRepository;

    @Inject
    TeamFacade teamRepository;

    @Context
    private UriInfo context;

    public TeamStudentResource() {
    }

    //TEST ECHO Server
    @GET
    @Path("message")
    public String message() {
        return "Hello REST!";
    }

    @GET
    @Path("init")
    public String addUser() {
        Team t1 = new Team("5AHITM", "E120");
        Team t2 = new Team("4AHIF", "E58");

        Student s1 = new Student("Bernhard", "Fröschl", 75.0);
        Student s2 = new Student("Bernd", "Breitenauer", 40.0);
        Student s3 = new Student("Rowa", "Audil", 90.0);
        Student s4 = new Student("Jakob", "Hanner", 85.0);
        Student s5 = new Student("Roman", "Peherstofer", 82.0);
        Student s6 = new Student("Matthias", "Skopek", 97.0);

        Student s0 = new Student("Raul", "Kögi", 78);

        s1.setTeam(t1);
        s2.setTeam(t1);
        s3.setTeam(t1);
        s4.setTeam(t1);
        s5.setTeam(t1);
        s6.setTeam(t1);

        s0.setTeam(t2);

        Task tk1 = new Task("programmieren");
        Task tk2 = new Task("modellieren");

        s1.addTask(tk1);
        s2.addTask(tk1);
        s3.addTask(tk2);
        s4.addTask(tk2);
        s5.addTask(tk1);
        s6.addTask(tk1);
        s0.addTask(tk2);

        studentRepository.edit(s1);
        studentRepository.edit(s2);
        studentRepository.edit(s3);
        studentRepository.edit(s4);
        studentRepository.edit(s5);
        studentRepository.edit(s6);
        studentRepository.edit(s0);

        return "DB initialized";
    }

    @GET
    @Path("findS")
    @Produces("application/json")
    public List<Student> findStudents() {
        return studentRepository.findStudents();
    }

    @GET
    @Path("findS/{sID}")
    @Produces("application/json")
    //Produces(MediaType.APPLICATION-JSON)
    public Student findStudentById(@PathParam("sID") int studentId) {
        Student s = studentRepository.findStudentById(studentId);
        return s;
    }

    @PUT
    @Path("updateS/{sID}")
    @Produces("application/json")
    public String updateStudent(@PathParam("sID") int studentId, Student student) {
        student.setStudentId(studentId);
        studentRepository.edit(student);
        return student.getFirstName() + " " + student.getLastName() + " wurden hinzugefügt!";
    }
    
    @PUT
    @Path("createS")
    @Produces("application/json")
    public String createStudent(Student student) {
        student.getStudentId();
        studentRepository.edit(student);
        return student.getStudentId() + " wurden hinzugefügt!";
    }

    @DELETE
    @Path("deleteS/{sID}")
    @Produces("application/json")
    public String deleteStudent(@PathParam("sID") int studentId) {
        Student s = studentRepository.findStudentById(studentId);
        studentRepository.remove(s);
        return s.getFirstName() + " wurden gelöscht!";
    }
    

    @GET
    @Path("findT")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getAllTeams() {
        return teamRepository.findTeams();
    }

    @GET
    @Path("findT/{tID}")
    @Produces("application/json")
    public Team findTeamById(@PathParam("sID") String teamId) {
        Team t = teamRepository.findTeamById(teamId);
        return t;
    }

    @GET
    @Path("findSbyT/{tID}")
    @Produces("application/json")
    public List<Student> findStudentsByTeam(@PathParam("tID") String teamId) {
        List<Student> students = studentRepository.findStudentsByTeamId(teamId);
        return students;
    }

    @GET
    @Path("deleteT/{tID}")
    @Produces("application/text")
    public String deleteTeam(@PathParam("tID") String teamName) {
        teamRepository.deleteTeamByName(teamName);
        return "success";
    }
    
    @GET
    @Path("deleteTask/{sID}/{taskName}")
    @Produces("application/text")
    public String deleteTask(@PathParam("sID") int studentId, @PathParam("taskName") String taskName) {
        studentRepository.deleteTask(studentId, taskName);
        return "success";
    }

    //Student DeleteStudentById
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ApiResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
