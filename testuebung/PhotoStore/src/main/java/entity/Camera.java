/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jakob Hanner
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Camera.findById", query = "SELECT c FROM Camera c WHERE c.camId = :camId")
})
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int camId;
    private String name;
    private int amount;

    public Camera() {
    }

    public Camera(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getCamId() {
        return camId;
    }

    public void setCamId(int camId) {
        this.camId = camId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
