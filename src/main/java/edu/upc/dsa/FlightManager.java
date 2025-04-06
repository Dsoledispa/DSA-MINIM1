package edu.upc.dsa;

import edu.upc.dsa.exceptions.AirplaneNotFoundException;
import edu.upc.dsa.exceptions.FlightNotFoundException;
import edu.upc.dsa.models.Airplane;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;

public interface FlightManager {




    public Airplane addAirplane(Airplane a);
    public Airplane addAirplane(String model, String airline);
    public Airplane addAirplane(String id, String model, String airline);
    public Airplane getAirplane(String id);

    public Flight addFlight(Flight f) throws AirplaneNotFoundException;
    public Flight addFlight(String origin, String destination, String arrival_time, String departure_time, String id_airplane) throws AirplaneNotFoundException;
    public Flight addFlight(String id, String origin, String destination, String arrival_time, String departure_time, String id_airplane) throws AirplaneNotFoundException;
    public Flight getFlight(String id);


    public Bag addBag(Bag b) throws FlightNotFoundException;
    public Bag addBag(String id_user, String id_flight) throws FlightNotFoundException;
    public Bag addBag(String id, String id_user, String id_flight) throws FlightNotFoundException;

    public void clear();
    public int sizeAirplane();
    public int sizeFlight();
    public int sizeBag(Flight f);
}
