package org.mathiasus.models.facilities;

import org.mathiasus.models.facilities.enums.FaciltityType;

public abstract class Facility {
    private final String facilityIco;
    private final String facilityName;
    private final String facilityAddress;
    private final String facilityEmail;
    private final FaciltityType faciltityType;

    public Facility(String facilityIco, String facilityName, String facilityAddress, String facilityEmail, FaciltityType faciltityType) {
        this.facilityIco = facilityIco;
        this.facilityName = facilityName;
        this.facilityAddress = facilityAddress;
        this.facilityEmail = facilityEmail;
        this.faciltityType = faciltityType;
    }

    public String getFacilityAddress() {
        return facilityAddress;
    }

    public String getFacilityEmail() {
        return facilityEmail;
    }

    public String getFacilityIco() {
        return facilityIco;
    }

    public String getFacilityName() {
        return facilityName;
    }
}
