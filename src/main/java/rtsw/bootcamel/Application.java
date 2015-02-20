/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootcamel;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rtsw.bootcamel.domain.UserRepository;

/**
 *
 * @author b1050502
 */
@SpringBootApplication
@ImportResource({"${beans.file}"})
public class Application extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(Application.class, args);
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.info(beanName);
        }
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(applicationClass);
//    }
//
//    private static Class<Application> applicationClass = Application.class;
}



@RestController
class GreetingController {
    
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
    
    @Autowired
    private UserRepository repository;

    /**
     * get all Users based on Last Name
     * @param lastName
     * @return 
     */
    @RequestMapping("/lastname/{lastName}")
    String getUserLastName(@PathVariable String lastName) {
        log.info("locating users with last name: "+lastName);
        return repository.findByLastName(lastName).toString();
    }
    
    /**
     * get all Users based on First Name
     * @param firstName
     * @return 
     */
    @RequestMapping("/firstname/{firstName}")
    String getUserFirstName(@PathVariable String firstName) {
        log.info("locating users with first name: "+firstName);
        return repository.findByFirstName(firstName).toString();
    }
    
    
    /**
     * Get All Users
     * @return 
     */
    @RequestMapping("/users")
    String users() {
        return repository.findAll().toString();
    }

}
