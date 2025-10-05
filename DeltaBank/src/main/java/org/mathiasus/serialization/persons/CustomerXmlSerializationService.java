package org.mathiasus.serialization.persons;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.mathiasus.persons.customers.Customer;
import org.mathiasus.serialization.Serialization;
import javax.xml.bind.JAXB;
import java.io.StringWriter;

public class CustomerXmlSerializationService implements Serialization {
    private XmlMapper xmlMappper;


    public CustomerXmlSerializationService() {
        this.xmlMappper = new XmlMapper();

    }

    @Override
    public String serialize(Object serializable) {
        String xml = "<></>";
        try{
            xml = this.xmlMappper.writeValueAsString(serializable);
        }catch(Exception e){
            System.err.println("Error serializing object: " + e.getMessage());
        }
        return xml;
    }

    @Override
    public Object deserialize(String serializable) {
        try{
            return this.xmlMappper.readValue(serializable, Customer.class);
        }catch(Exception e){
            System.err.println("Error deserializing object: " + e.getMessage());
        }
        return null;
    }

}
