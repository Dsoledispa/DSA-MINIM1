package edu.upc.dsa;

import edu.upc.dsa.models.Airplane;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;
import edu.upc.dsa.models.User;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightManagerTest {
    FlightManager fm;

    @Before
    public void setUp() {
        this.fm = FlightManagerImpl.getInstance();
        this.fm.addAirplane("A1", "747", "Iberia");
        this.fm.addAirplane("A2", "777", "Iberia");
        this.fm.addAirplane("A3", "787", "Iberia");

        this.fm.addFligh("F1","Barcelona", "Madrid", "13:00", "14:00", "A1");
        this.fm.addFligh("F2","Barcelona", "Valencia", "14:00", "15:00", "A2");
        this.fm.addFligh("F3","Madrid", "Barcelona", "16:00", "17:00", "A3");
    }

    @After
    public void tearDown() {
        // És un Singleton
        this.fm.clear();
    }

    @Test
    public void addAirplaneTest() {
        Assert.assertEquals(3, fm.sizeAirplane());

        this.fm.addAirplane("A4","797", "Iberia");

        Assert.assertEquals(4, fm.sizeAirplane());

    }

    @Test
    public void addFlightTest() {
        Assert.assertEquals(3, fm.sizeFlight());

        this.fm.addFligh("F4","Madrid", "Paris", "16:00", "20:00", "A3");

        Assert.assertEquals(4, fm.sizeFlight());

    }
}
