package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class Flight {
    String id;
    String origin;
    String destination;
    //por ahora string
    String arrival_time;
    String departure_time;

    String id_airplane;
    List<Bag> bags;

    // Constructor vacio
    public Flight() {

        this.setId(RandomUtils.getId());
        this.bags = new LinkedList<>();
    }
    // Constructor
    // Constructor
    public Flight(String origin, String destination, String arrival_time, String departure_time, String id_airplane) {
        this(null, origin, destination, arrival_time, departure_time, id_airplane);
    }
    // Constructor

    // Constructor
    public Flight(String id, String origin, String destination, String arrival_time, String departure_time, String id_airplane) {
        this(); // Llama al constructor sin parámetros (asigna un id aleatorio).
        if (id != null) this.setId(id); // Si se proporciona un id, lo sobrescribe.
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setArrival_time(arrival_time);
        this.setDeparture_time(departure_time);
        this.setId_airplane(id_airplane);
        this.bags = new LinkedList<>();
        //this.setBags(bags);
    }
    // Constructor

    // getters y setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getArrival_time() {
        return arrival_time;
    }
    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }
    public String getDeparture_time() {
        return departure_time;
    }
    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }
    public String getId_airplane() {
        return id_airplane;
    }
    public void setId_airplane(String id_airplane) {
        this.id_airplane = id_airplane;
    }
    public List<Bag> getBags() {return bags;}
    public void setBags(List<Bag> bags) {this.bags = bags;}


    // getters y setters

    @Override
    public String toString() {
        return "Flight [id="+id+", origin=" + origin + ", destination=" + destination +", arrival_time=" + arrival_time+", departure_time=" + departure_time + ", id_airplane="+id_airplane+", bags="+bags+"]";
    }
}
