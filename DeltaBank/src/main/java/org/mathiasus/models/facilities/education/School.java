package org.mathiasus.models.facilities.education;

import org.mathiasus.models.facilities.Facility;
import org.mathiasus.models.facilities.enums.FaciltityType;

public class School extends Facility {
    public School(){

    }
    public School(String facilityIco, String facilityName, String facilityAddress, String facilityEmail, FaciltityType faciltityType) {
        super(facilityIco, facilityName, facilityAddress, facilityEmail, faciltityType);
    }
}
