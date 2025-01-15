package com.wecp.entity;


public class Director {
    private int directorId;
    private String directorName;

    public Director(){}
    
    public Director(int directorId, String directorName) {
        this.directorId = directorId;
        this.directorName = directorName;
    }
    public int getDirectorId() {
        return directorId;
    }
    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }
    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    

}
