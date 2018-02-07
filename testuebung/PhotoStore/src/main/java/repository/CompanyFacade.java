/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Company;
import entity.Store;
import java.util.List;
import static repository.AbstractFacade.em;

/**
 *
 * @author Jakob Hanner
 */
public class CompanyFacade extends AbstractFacade<Company>{
    
    public CompanyFacade(){
        super(Company.class);
    }

    public List<Store> findStoresByC(int cID) {
        Company getCompany = em.createNamedQuery("Company.findById", Company.class).setParameter("companyId", cID).getSingleResult();
        return getCompany.getStores();
    }

}
