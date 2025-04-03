package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Bag {
    String id;
    String id_user;
    Boolean checkin;

    // Constructor vacio
    public Bag() {
        this.setId(RandomUtils.getId());
    }
    // Constructor
    // Constructor
    public Bag(String id_user, Boolean checkin) {
        this(null, id_user, checkin);
    }
    // Constructor

    // Constructor
    public Bag(String id, String id_user, Boolean checkin) {
        this(); // Llama al constructor sin parámetros (asigna un id aleatorio).
        if (id != null) this.setId(id); // Si se proporciona un id, lo sobrescribe.
        this.setId_user(id_user);
        this.setCheckin(checkin);
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
    public Boolean getCheckin(){
        return  this.checkin;
    }
    public void setCheckin(Boolean checkin){
        this.checkin=checkin;
    }


    // getters y setters

    @Override
    public String toString() {
        return "Bag [id="+id+"]";
    }
}
