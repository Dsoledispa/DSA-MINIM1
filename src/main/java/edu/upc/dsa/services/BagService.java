package edu.upc.dsa.services;


import edu.upc.dsa.FlightManager;
import edu.upc.dsa.FlightManagerImpl;
import edu.upc.dsa.exceptions.AirplaneNotFoundException;
import edu.upc.dsa.exceptions.FlightNotFoundException;
import edu.upc.dsa.models.Bag;
import edu.upc.dsa.models.Flight;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/bags", description = "Endpoint to bags Service")
@Path("/bags")
public class BagService {

    final static Logger logger = Logger.getLogger(FlightService.class); // Log4j
    private FlightManager fm; // fm es una instancia del FlightManager (implementado como Singleton).

    public BagService() throws Exception {
        this.fm = FlightManagerImpl.getInstance();

        if (fm.sizeAirplane()==0) {
            this.fm.addAirplane("A1", "747", "Iberia");
            this.fm.addAirplane("A2", "777", "Iberia");
            this.fm.addAirplane("A3", "787", "Iberia");
        }
        if (fm.sizeFlight()==0) {
            this.fm.addFlight("F1","Barcelona", "Madrid", "13:00", "14:00", "A1");
            this.fm.addFlight("F2","Barcelona", "Valencia", "14:00", "15:00", "A2");
            this.fm.addFlight("F3","Madrid", "Barcelona", "16:00", "17:00", "A3");
        }
        if (fm.sizeBag(this.fm.getFlight("F1"))==0){
            this.fm.addBag("B1", "46499729P", "F1");
            this.fm.addBag("B2", "46499729P", "F1");
            this.fm.addBag("B3", "46499729P", "F1");
        }


    }

    @POST
    @ApiOperation(value = "create a new Bag", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Flight.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBag(Bag b) throws FlightNotFoundException {

        if (b.getId_user()==null || b.getId_flight()==null)  return Response.status(500).entity(b).build();
        this.fm.addBag(b) ;
        return Response.status(201).entity(b).build();
    }

}
