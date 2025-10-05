package org.mathiasus.serialization.facilities;

import org.mathiasus.models.facilities.Facility;
import org.mathiasus.models.facilities.enums.FaciltityType;

public class FacilitySerialization {
    public String facilityIco;
    public String facilityName;
    public String facilityAddress;
    public String facilityEmail;
    public FaciltityType faciltityType;

    public FacilitySerialization(Facility facility){
        this.faciltityType = facility.getFaciltityType();
        this.facilityEmail = facility.getFacilityEmail();
        this.facilityName = facility.getFacilityName();
        this.facilityAddress = facility.getFacilityAddress();
        this.facilityIco = facility.getFacilityIco();
    }
}
