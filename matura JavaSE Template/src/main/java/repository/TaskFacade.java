package repository;

import entity.Task;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author H. Lackinger
 */

public class TaskFacade extends AbstractFacade<Task> {



    public TaskFacade() {
        super(Task.class);
    }

}
