package repository;

import entity.Student;
import entity.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author H. Lackinger
 */

public class StudentFacade extends AbstractFacade<Student> {



    public StudentFacade() {
        super(Student.class);
    }

    /**
     * Find students by teamId
     */
    public List<Student> findStudentsByTeam(String teamId) {

        List<Student> resultList = em.createNamedQuery( "Student.findByTeam", Student.class)
                                     .setParameter("teamId", teamId)
                                     .getResultList();
   
        return resultList;
    }

    /**
     * Find a student by studentId
     */
    public Student findStudentById(int studentId) {
        return em.find(Student.class, studentId);
    }

    /**
     * Delete a student by studentId
     */    
    public void remove(int studentId) {
        em.getTransaction().begin();
        em.remove(em.find(Student.class,studentId));
        em.getTransaction().commit();
    }



}
