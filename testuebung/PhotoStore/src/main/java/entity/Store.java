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
    @NamedQuery(name = "Store.findById", query = "SELECT s FROM Store s WHERE s.storeId = :storeId")
})
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storeId;
    private String location;
    private int employee;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Brand> brands = new ArrayList<>();

    public Store() {
    }

    public Store(String location, int employee) {
        this.location = location;
        this.employee = employee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void addBrand(Brand brand) {
        this.brands.add(brand);
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    
}
