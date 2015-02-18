/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootcamel.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author b1050502
 */

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

   @XmlAttribute
    private int age;

    
    public User() {}

    public User(int age) {
        this();
        this.age = age;
    }
    
   
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
   @Override public String toString() {
        return "User{" + "age=" + age + '}';
    }
}