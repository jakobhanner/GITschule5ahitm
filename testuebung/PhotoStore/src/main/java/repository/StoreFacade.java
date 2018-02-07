/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Brand;
import entity.Store;
import java.util.List;
import static repository.AbstractFacade.em;

/**
 *
 * @author Jakob Hanner
 */
public class StoreFacade extends AbstractFacade<Store>{

    public StoreFacade(){
        super(Store.class);
    }

    public List<Brand> findBrandByStore(int sID) {
        Store getStore = em.createNamedQuery("Company.findById", Store.class).setParameter("storeId", sID).getSingleResult();
        return getStore.getBrands();
    }

    
}
