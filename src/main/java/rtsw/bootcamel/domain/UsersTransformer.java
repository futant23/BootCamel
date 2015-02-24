/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootcamel.domain;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author b1050502
 */
public class UsersTransformer {
    public synchronized String toXml(final Users users){
		 final StringWriter stringWriter = new StringWriter();
	        try {
	        	JAXBContext context = JAXBContext.newInstance(Users.class);
	        	Marshaller marshaller =  context.createMarshaller();
	        	
	        	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        	marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
	   		    if(users==null) {
	   		    	Users bbean =new Users();
	   		    	marshaller.marshal(bbean, stringWriter);	
	   		    }	
	   		    else{
	   		    	marshaller.marshal(users, stringWriter);
	   		    }
			} catch (Exception e) {
				e.printStackTrace();
			}
	        finally{	
	        }
	        return stringWriter.toString();
	}

	public synchronized Users fromXml(String xml) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		StringReader reader = new StringReader(xml);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Users bean= (Users) jaxbUnmarshaller.unmarshal(reader);
	    return bean;
	}

}
