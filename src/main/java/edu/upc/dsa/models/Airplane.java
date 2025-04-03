package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Airplane {

    String id;
    String model;
    String airline;
    //por ahora string

    // Constructor vacio
    public Airplane() {
        this.setId(RandomUtils.getId());
    }
    // Constructor
    // Constructor
    public Airplane(String model, String airline) {
        this(null, model, airline);
    }
    // Constructor

    // Constructor
    public Airplane(String id, String model, String airline) {
        this(); // Llama al constructor sin parámetros (asigna un id aleatorio).
        if (id != null) this.setId(id); // Si se proporciona un id, lo sobrescribe.
        this.setModel(model);
        this.setAirline(airline);
    }
    // Constructor

    // getters y setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }


    // getters y setters

    @Override
    public String toString() {
        return "Airplane [id="+id+", model=" + model + ", airline=" + airline +"]";
    }

}
