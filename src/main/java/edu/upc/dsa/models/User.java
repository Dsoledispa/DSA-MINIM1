package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class User {
    String DNI;

    // Constructor vacio
    public User() {}
    // Constructor

    // Constructor
    public User(String DNI) {
        this.setDNI(DNI);
    }
    // Constructor

    // getters y setters
    public String getDNI() {
        return this.DNI;
    }
    public void setDNI(String DNI) {
        this.DNI=DNI;
    }


    // getters y setters

    @Override
    public String toString() {
        return "User [DNI="+DNI+"]";
    }
}
