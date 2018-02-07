/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jakob
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ChatGroup.findAll", query = "SELECT c FROM ChatGroup c")
})
public class ChatGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String groupname;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    List<Person> listener = new ArrayList<>();

    public ChatGroup() {
    }

    public ChatGroup(int id, String groupname) {
        this.id = id;
        this.groupname = groupname;
    }

    public ChatGroup(String groupname) {
        this.groupname = groupname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<Person> getListener() {
        return listener;
    }

    public void setListener(List<Person> listener) {
        this.listener = listener;
    }
    
    public void addListener(Person p) {
        this.listener.add(p);
    }
}
