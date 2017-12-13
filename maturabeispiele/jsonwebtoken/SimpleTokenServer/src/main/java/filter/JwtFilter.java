/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import service.JwtBuilder;

/**
 *
 * @author Jakob
 */
@Provider
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        if (crc.getUriInfo().getPath().contains("jwt") || crc.getMethod().equals("OPTIONS")) {
            return;
        }
        JwtBuilder jwtbuilder = new JwtBuilder();

        try {
            String[] auth = crc.getHeaderString("Authorization").split("\\s");
            String subject = jwtbuilder.checkSubject(auth[1]);
        } catch (Exception ex) {
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
    }
}
