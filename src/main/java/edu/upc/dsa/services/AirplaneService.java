package edu.upc.dsa.services;

import edu.upc.dsa.FlightManager;
import edu.upc.dsa.FlightManagerImpl;
import edu.upc.dsa.exceptions.AirplaneNotFoundException;
import edu.upc.dsa.models.Airplane;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api(value = "/airplanes", description = "Endpoint to Track Service")
@Path("/airplanes")
public class AirplaneService {

    final static Logger logger = Logger.getLogger(AirplaneService.class); // Log4j
    private FlightManager fm; // fm es una instancia del TracksManager (implementado como Singleton).

    public AirplaneService() throws Exception {
        this.fm = FlightManagerImpl.getInstance();
        if (fm.sizeAirplane()==0) {
            this.fm.addAirplane("A1", "747", "Iberia");
            this.fm.addAirplane("A2", "777", "Iberia");
            this.fm.addAirplane("A3", "787", "Iberia");
        }
        if (fm.sizeFlight()==0) {
            this.fm.addFlight("F1", "Barcelona", "Madrid", "13:00", "14:00", "A1");
            this.fm.addFlight("F2", "Barcelona", "Valencia", "14:00", "15:00", "A2");
            this.fm.addFlight("F3", "Madrid", "Barcelona", "16:00", "17:00", "A3");
        }


    }

    @POST
    @ApiOperation(value = "create a new Airplane", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Airplane.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newAirplane(Airplane airplane) {

        if (airplane.getModel()==null || airplane.getAirline()==null)  return Response.status(500).entity(airplane).build();
        this.fm.addAirplane(airplane);
        return Response.status(201).entity(airplane).build();
    }
}