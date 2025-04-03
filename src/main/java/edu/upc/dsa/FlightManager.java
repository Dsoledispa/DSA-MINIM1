package edu.upc.dsa;

import edu.upc.dsa.models.Airplane;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;
import edu.upc.dsa.models.User;

public interface FlightManager {




    public Airplane addAirplane(Airplane a);
    public Airplane addAirplane(String model, String airline);
    public Airplane addAirplane(String id, String model, String airline);

    public Flight addFligh(Flight f);
    public Flight addFligh(String origin, String destination, String arrival_time, String departure_time, String id_airplane);
    public Flight addFligh(String id, String origin, String destination, String arrival_time, String departure_time, String id_airplane);


    public Bag addBag();
    public void checkinBag();
    public void provideBag();

    public User addUser();

    public void clear();
    public int sizeAirplane();
    public int sizeFlight();

}
