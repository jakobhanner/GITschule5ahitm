/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Project;
import java.util.List;

/**
 *
 * @author Jakob Hanner
 */
public class ProjectFacade extends AbstractFacade<Project> {

    public ProjectFacade() {
        super(Project.class);
    }
    
    public Project findProjectById(int projectId){   
        return em.createNamedQuery("Project.findProjectById", Project.class).setParameter("projectId", projectId).getSingleResult();
    }

}
