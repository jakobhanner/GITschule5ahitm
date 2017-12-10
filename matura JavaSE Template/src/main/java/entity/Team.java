package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author H. Lackinger
 */
@Entity
public class Team {
    
    @Id 
    private String teamId;
    private String teamRoom;

    public Team() {
    }

    public Team(String teamId, String teamRoom) {
        this.teamId = teamId;
        this.teamRoom = teamRoom;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamRoom() {
        return teamRoom;
    }

    public void setTeamRoom(String teamRoom) {
        this.teamRoom = teamRoom;
    }


}
