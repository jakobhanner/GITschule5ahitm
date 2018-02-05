/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Jakob Hanner
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Brand.findById", query = "SELECT b FROM Brand b WHERE b.brandId = :brandId")
})
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brandId;
    private String brandName;
    private String location;
    private String contactPerson;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Camera> cameras = new ArrayList<>();

    public Brand() {
    }

    public Brand(String brandName, String location, String contactPerson) {
        this.brandName = brandName;
        this.location = location;
        this.contactPerson = contactPerson;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }
    

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
    
    public void addCam(Camera cam){
        this.cameras.add(cam);
    }
    
    

}
