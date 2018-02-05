/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Interaction;
import entity.Player;
import entity.Project;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import repository.InteractionFacade;
import repository.PlayerFacade;
import repository.ProjectFacade;

/**
 *
 * @author Jakob Hanner
 */
@Path("rest")
public class RESTservices {

    PlayerFacade playerRepository = new PlayerFacade();
    ProjectFacade projectRepository = new ProjectFacade();
    InteractionFacade interactionRepository = new InteractionFacade();

    @Context
    private UriInfo context;

    public RESTservices() {

    }

    @GET
    @Path("init")
    public String initDB() {
        Player p1 = new Player("Jakob Hanner", 19);
        Player p2 = new Player("Bernhard Froeschl", 19);

        Project pr1 = new Project("create");
        Project pr2 = new Project("decide");
        Project pr3 = new Project("decide");
        Project pr4 = new Project("decide");
        Project pr5 = new Project("decide");
        Project pr6 = new Project("create2");

        List<Project> projects = new ArrayList<>();
        List<Project> projects1 = new ArrayList<>();

        Interaction i1 = new Interaction("LeftOrRight");
        Interaction i2 = new Interaction("UpOrDown");
        Interaction i3 = new Interaction("AOrB");

        List<Interaction> interactionsPr1 = new ArrayList<>();
        interactionsPr1.add(i1);
        interactionsPr1.add(i2);

        List<Interaction> interactionsPr2 = new ArrayList<>();
        interactionsPr2.add(i1);
        interactionsPr2.add(i2);
        interactionsPr2.add(i3);

        pr1.setInteractions(interactionsPr1);
        pr2.setInteractions(interactionsPr2);
        pr2.setInteractions(interactionsPr2);

        projects.add(pr1);
        projects.add(pr2);
        projects.add(pr3);
        projects.add(pr4);
        projects1.add(pr4);
        projects1.add(pr5);
        projects1.add(pr6);

        p1.setProjects(projects);
        p2.setProjects(projects1);
        

        playerRepository.edit(p1);
        playerRepository.edit(p2);

        return "DB initialized";
    }

    @GET
    @Path("loadAllPlayer")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> loadPlayer() {
        return playerRepository.findAll();
    }

    @PUT
    @Path("updateProject/{projectID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProject(@PathParam("projectID") int projectId, Project project) {
        project.setProjectId(projectId);
        projectRepository.edit(project);
    }

    @DELETE
    @Path("deleteProject/{projectID}")
    public void deleteProject(@PathParam("projectID") int projectId) {
        Project p = projectRepository.findProjectById(projectId);
        for (int i = 0; i < p.getInteractions().size(); i++) {
            interactionRepository.remove(p.getInteractions().get(i));
        }
        
        projectRepository.remove(p);
    }

    @PUT
    @Path("addInteraction/{interaction}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addInteraction(@PathParam("interaction") String interaction, Project project) {
        project.getInteractions().add(new Interaction(interaction));
        project.setInteractions(project.getInteractions());
        projectRepository.edit(project);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
