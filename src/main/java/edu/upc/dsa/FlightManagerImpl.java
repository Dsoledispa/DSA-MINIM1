package edu.upc.dsa;

import edu.upc.dsa.models.Airplane;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.List;

public class FlightManagerImpl implements FlightManager {

    private static FlightManager instance; // singleton
    protected List<Airplane> airplanes;
    final static Logger logger = Logger.getLogger(FlightManagerImpl.class); // Log4j

    // Patron singleton
    public static FlightManager getInstance() {
        if (instance==null) instance = new FlightManagerImpl();
        return instance;
    }
    // Patron singleton


    @Override
    public Flight addFligh() {
        return null;
    }

    @Override
    public Airplane addAirplane(Airplane a) {
        logger.info("new Airplane " + a);

        this.airplanes.add (a);
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
    public User addUser() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
