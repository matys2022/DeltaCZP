package org.mathiasus.serialization.accounts;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.mathiasus.accounts.SaveAccount;
import org.mathiasus.persons.customers.Customer;
import org.mathiasus.serialization.Serialization;

import javax.xml.bind.JAXB;
import java.io.StringWriter;

public class SaveAccountXmlSerializationService implements Serialization {

    private final XmlMapper xmlMapper;

    public SaveAccountXmlSerializationService() {
        this.xmlMapper = new XmlMapper();

    }

    @Override
    public String serialize(Object serializable) {
        String xml = "";
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
            return this.xmlMapper.readValue(serializable, SaveAccount.class);
        }catch(Exception e){
            System.err.println("Error deserializing object: " + e.getMessage());
        }
        return null;
    }
}
