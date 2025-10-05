package org.mathiasus.serialization.facilities;

import org.mathiasus.models.facilities.Facility;
import org.mathiasus.models.facilities.education.School;
import org.mathiasus.models.facilities.enums.FaciltityType;

public class FacilitySerializationFactory {


    public FacilitySerializationFactory(){
    }

    public SchoolSerialization createSchoolSerialization(Facility facility)
    {
        if(facility instanceof School){
            return new SchoolSerialization((School)facility);
        }
        throw new IllegalArgumentException("Facility type is not a school facility");
    }

}
