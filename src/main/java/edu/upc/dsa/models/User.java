package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class User {
    String DNI;
    public List<Bag> bags;

    // Constructor vacio
    public User() {}
    // Constructor

    // Constructor
    public User(String DNI, List<Bag> bags) {
        this.setDNI(DNI);
        this.bags = new LinkedList<>();
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
