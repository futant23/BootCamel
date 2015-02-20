/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootcamel.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author b1050502
 */
public interface UserRepository extends CrudRepository<User, Long>{
    
    List<User> findByLastName(String lastName);
    
    List<User> findByFirstName(String firstName);
}
