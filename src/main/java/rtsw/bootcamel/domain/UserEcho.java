/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootcamel.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author b1050502
 */
public class UserEcho {
    
    private final static Logger log =LoggerFactory.getLogger(UserEcho.class);
    
    @Autowired
    private UserRepository repository;
    
    public void echo(String msg) {
        log.info("string echo: "+msg);
    }
    
    public void echo(User user) {
        log.info("saving user: "+user.toString());
        repository.save(user);
    }
}
