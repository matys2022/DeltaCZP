package org.mathiasus.serialization.facilities;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.serialization.Serialization;


public class SchoolXmlSerializationService implements Serialization {

    private final XmlMapper xmlMapper;

    public SchoolXmlSerializationService() {
        this.xmlMapper = new XmlMapper();
    }



    @Override
    public String serialize(Object serializable) {
        String xml = "<></>";
        try{
            xml = this.xmlMapper.writeValueAsString(serializable);
        }catch(Exception e){
            System.err.println("Error serializing object: " + e.getMessage());
        }
        return xml;
    }

    @Override
    public Object deserialize(String serializable) {
        try{
            return this.xmlMapper.readValue(serializable, School.class);
        }catch(Exception e){
            System.err.println("Error deserializing object: " + e.getMessage());
        }
        return null;
    }

}
