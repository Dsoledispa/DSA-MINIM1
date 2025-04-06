package edu.upc.dsa;

import edu.upc.dsa.exceptions.AirplaneNotFoundException;
import edu.upc.dsa.exceptions.FlightNotFoundException;
import edu.upc.dsa.services.FlightService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightManagerTest {
    final static Logger logger = Logger.getLogger(FlightManagerTest.class); //
    FlightManager fm;

    @Before
    public void setUp() throws Exception {
        this.fm = FlightManagerImpl.getInstance();
        this.fm.addAirplane("A1", "747", "Iberia");
        this.fm.addAirplane("A2", "777", "Iberia");
        this.fm.addAirplane("A3", "787", "Iberia");

        this.fm.addFlight("F1","Barcelona", "Madrid", "13:00", "14:00", "A1");
        this.fm.addFlight("F2","Barcelona", "Valencia", "14:00", "15:00", "A2");
        this.fm.addFlight("F3","Madrid", "Barcelona", "16:00", "17:00", "A3");

        this.fm.addBag("B1", "46499729P", "F1");
        this.fm.addBag("B2", "46499729P", "F1");
        this.fm.addBag("B3", "46499729P", "F1");

        Assert.assertThrows(AirplaneNotFoundException.class, () ->
                this.fm.addFlight("F4","Madrid", "Barcelona", "16:00", "17:00", "XXXXXX"));

        Assert.assertThrows(FlightNotFoundException.class, () ->
                this.fm.addBag("B4", "46499729P", "YYYYYY"));
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
    public void addFlightTest() throws Exception {
        Assert.assertEquals(3, fm.sizeFlight());

        this.fm.addFlight("F4","Madrid", "Paris", "16:00", "20:00", "A3");

        Assert.assertEquals(4, fm.sizeFlight());

        Assert.assertThrows(AirplaneNotFoundException.class, () ->
                this.fm.addFlight("F5","Madrid", "Barcelona", "16:00", "17:00", "XXXXXX"));

    }

    @Test
    public void addBagTestFlightF1() throws Exception {
        Assert.assertEquals(3, fm.sizeBag(this.fm.getFlight("F1")));

        this.fm.addBag("B4", "46499729P", "F1");

        Assert.assertEquals(4, fm.sizeBag(this.fm.getFlight("F1")));

        Assert.assertThrows(FlightNotFoundException.class, () ->
                this.fm.addBag("B5", "46499729P", "YYYYYY"));
    }

    @Test
    public void checkBagTest() throws Exception {
        this.fm.checkBag("F1");

        Assert.assertThrows(FlightNotFoundException.class, () ->
                this.fm.checkBag("zzzzzz"));
    }

}
