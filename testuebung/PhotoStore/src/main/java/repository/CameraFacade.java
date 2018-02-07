/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Camera;

/**
 *
 * @author Jakob Hanner
 */
public class CameraFacade extends AbstractFacade<Camera>{
    
    public CameraFacade(){
        super(Camera.class);
    }
    
    public Camera findById(int cId){
        return em.createNamedQuery("Camera.findById", Camera.class).setParameter("camId", cId).getSingleResult();
    }
    
}
