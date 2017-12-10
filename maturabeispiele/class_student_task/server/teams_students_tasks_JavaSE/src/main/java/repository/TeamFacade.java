package repository;

import entity.Team;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author H. Lackinger
 */

public class TeamFacade extends AbstractFacade<Team> {



    public TeamFacade() {
        super(Team.class);
    }

}
