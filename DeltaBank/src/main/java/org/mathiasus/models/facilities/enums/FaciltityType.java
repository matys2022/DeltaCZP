package org.mathiasus.models.facilities.enums;

public enum FaciltityType {

    School("000");


    public final String code;

    private FaciltityType(String label) {
        this.code = label;
    }
}
