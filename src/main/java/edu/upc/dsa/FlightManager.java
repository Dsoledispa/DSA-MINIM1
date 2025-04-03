package edu.upc.dsa;

import edu.upc.dsa.models.Airplane;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;
import edu.upc.dsa.models.User;

public interface FlightManager {


    public Flight addFligh();

    public Airplane addAirplane(Airplane a);
    public Airplane addAirplane(String model, String airline);
    public Airplane addAirplane(String id, String model, String airline);

    public Bag addBag();
    public void checkinBag();
    public void provideBag();

    public User addUser();

    public void clear();
    public int size();

}
