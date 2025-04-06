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


    public Bag addBag();

    public void clear();
    public int sizeAirplane();
    public int sizeFlight();

}
