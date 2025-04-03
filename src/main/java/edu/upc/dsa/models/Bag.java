package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Bag {
    String id;

    // Constructor vacio
    public Bag() {
        this.setId(RandomUtils.getId());
    }
    // Constructor
    // Constructor

    // Constructor
    public Bag(String id) {
        this(); // Llama al constructor sin parámetros (asigna un id aleatorio).
        if (id != null) this.setId(id); // Si se proporciona un id, lo sobrescribe.
    }
    // Constructor

    // getters y setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }


    // getters y setters

    @Override
    public String toString() {
        return "Bag [id="+id+"]";
    }
}
