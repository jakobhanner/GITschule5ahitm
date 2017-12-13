/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entity.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import service.JwtBuilder;

/**
 *
 * @author Jakob
 */
public class Ressource {
    
    @Path("jwt")
    public class JwtResource{
        @POST
        @Consumes({MediaType.APPLICATION_JSON})
        public String post(User user){
            if (checkUser(user))
                return new JwtBuilder().create(user.getUsername());
            return null;
        }

        private boolean checkUser(User user) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
