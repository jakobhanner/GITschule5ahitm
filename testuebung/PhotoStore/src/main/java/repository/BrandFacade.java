/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Brand;
import entity.Camera;
import java.util.List;

/**
 *
 * @author Jakob Hanner
 */
public class BrandFacade extends AbstractFacade<Brand>{
    
    public BrandFacade() {
        super(Brand.class);
    }

    public List<Camera> findCamByBrand(int bID) {
        Brand getBrand = em.createNamedQuery("Brand.findById", Brand.class).setParameter("brandId", bID).getSingleResult();
        return getBrand.getCameras();
    }

    
    public Brand findById(int bId){
        return em.createNamedQuery("Brand.findById", Brand.class).setParameter("brandId", bId).getSingleResult();
    }
    
}
