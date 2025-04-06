package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Bag {
    String id;
    String id_user;
    String id_flight;

    // Constructor vacio
    public Bag() {
        this.setId(RandomUtils.getId());
    }
    // Constructor
    // Constructor
    public Bag(String id_user, String id_flight) {
        this(null, id_user, id_flight);
    }
    // Constructor

    // Constructor
    public Bag(String id, String id_user, String id_flight) {
        this(); // Llama al constructor sin parámetros (asigna un id aleatorio).
        if (id != null) this.setId(id); // Si se proporciona un id, lo sobrescribe.
        this.setId_user(id_user);
        this.setId_flight(id_flight);
    }
    // Constructor

    // getters y setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }
    public String getId_user(){
        return this.id_user;
    }
    public void setId_user(String id_user){
        this.id_user=id_user;
    }
    public String getId_flight(){
        return this.id_flight;
    }
    public void setId_flight(String id_flight){
        this.id_flight=id_flight;
    }


    // getters y setters

    @Override
    public String toString() {
        return "Bag [id="+id+", id_user="+id_user+", id_flight="+id_flight+"]";
    }
}
