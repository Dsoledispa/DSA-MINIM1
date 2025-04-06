package edu.upc.dsa;

import edu.upc.dsa.models.Airplane;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class FlightManagerImpl implements FlightManager {

    private static FlightManager instance; // singleton
    protected List<Airplane> airplanes;
    protected List<Flight> flights;
    final static Logger logger = Logger.getLogger(FlightManagerImpl.class); // Log4j

    // Constructor privado
    private FlightManagerImpl() {
        this.airplanes = new LinkedList<>();
        this.flights = new LinkedList<>();
    }
    // Constructor privado

    // Patron singleton
    public static FlightManager getInstance() {
        if (instance==null) instance = new FlightManagerImpl();
        return instance;
    }
    // Patron singleton

    @Override
    public Airplane addAirplane(Airplane a) {
        logger.info("new Airplane " + a);

        this.airplanes.add(a);
        logger.info("new Airplane added");
        return a;
    }

    @Override
    public Airplane addAirplane(String model, String airline){
        return this.addAirplane(null, model, airline);
    }

    @Override
    public Airplane addAirplane(String id, String model, String airline) {
        return this.addAirplane(new Airplane(id, model, airline));

    }

    @Override
    public Flight addFlight(Flight f) {
        logger.info("new Flight " + f);

        this.flights.add(f);
        logger.info("new Flight added");
        return f;
    }

    @Override
    public Flight addFlight(String origin, String destination, String arrival_time, String departure_time, String id_airplane) {
        return this.addFlight(null, origin, destination, arrival_time, departure_time, id_airplane);
    }

    @Override
    public Flight addFlight(String id, String origin, String destination, String arrival_time, String departure_time, String id_airplane) {
        return this.addFlight(new Flight(id, origin, destination, arrival_time, departure_time, id_airplane));
    }

    @Override
    public Bag addBag() {
        return null;
    }

    @Override
    public void checkinBag() {

    }

    @Override
    public void provideBag() {

    }

    @Override
    public void clear() {
        this.airplanes.clear();
        this.flights.clear();
    }

    @Override
    public int sizeAirplane() {
        int aviones = this.airplanes.size();
        logger.info("size " + aviones);

        return aviones;
    }

    @Override
    public int sizeFlight() {
        int vuelos = this.flights.size();
        logger.info("size " + vuelos);

        return  vuelos;
    }

}
