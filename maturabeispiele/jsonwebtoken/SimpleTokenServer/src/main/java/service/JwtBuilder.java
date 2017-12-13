/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author Jakob
 */
public class JwtBuilder {

    private String key = "secret";

    public String create(String subject) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .compact();
    }

    //Subject Claims aufrufen
    public String checkSubject(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    
}
