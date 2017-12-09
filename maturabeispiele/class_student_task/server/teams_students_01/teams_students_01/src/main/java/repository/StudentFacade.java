/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Student;
import entity.Task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jakob
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "htl_teamsstudents")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    public Student findStudentById(int studentId) {
        return em.find(Student.class, studentId);
    }

    public List<Student> findStudentsByTeamId(String teamId) {
        return em.createNamedQuery("Student.findByTeam", Student.class).setParameter("teamId", teamId).getResultList();
    }

    public Student deleteStudentById(int studentId) {
        Student s = findStudentById(studentId);
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        return s;
    }

    public List<Student> findStudents() {
        return em.createNamedQuery("Student.findAllStudents", Student.class).getResultList();
    }


    public void deleteTask(int studentId, String taskName) {
        Student s = findStudentById(studentId);
       
        for (int i = 0; i < s.getTasks().size(); i++) {
            if(taskName == s.getTasks().get(i).getDescription()){
                em.getTransaction().begin();
                em.remove(s.getTasks().get(i));
                em.getTransaction().commit();
            }
        }
        
    }
    
}
