package entity;

import javax.persistence.*;

/**
 *
 * @author H. Lackinger
 */
@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int taskId;

    String taskDescription;

    public Task() {
    }

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    
    
    

}
