package edu.upc.dsa;

import edu.upc.dsa.exceptions.AirplaneNotFoundException;
import edu.upc.dsa.exceptions.FlightNotFoundException;
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
    public Airplane getAirplane(String id) {
        logger.info("getAirplane("+ id +")");
        for (Airplane a: this.airplanes) {
            if (a.getId().equals(id)) {
                logger.info("getAirplane("+ id +"): "+a);
                return a;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    @Override
    public Flight addFlight(Flight f) throws AirplaneNotFoundException {
        logger.info("new Flight " + f);
        if (getAirplane(f.getId_airplane()) == null){
            logger.error("Airplane with id= "+f.getId_airplane()+" not found");
            throw new AirplaneNotFoundException();
        }

        this.flights.add(f);
        logger.info("new Flight added");
        return f;
    }

    @Override
    public Flight addFlight(String origin, String destination, String arrival_time, String departure_time, String id_airplane) throws AirplaneNotFoundException {
        return this.addFlight(null, origin, destination, arrival_time, departure_time, id_airplane);
    }

    @Override
    public Flight addFlight(String id, String origin, String destination, String arrival_time, String departure_time, String id_airplane) throws AirplaneNotFoundException{
        return this.addFlight(new Flight(id, origin, destination, arrival_time, departure_time, id_airplane));
    }


    @Override
    public Bag addBag() {
        return null;
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
