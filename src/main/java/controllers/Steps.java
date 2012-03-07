package controllers;

import models.Step;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Path("/steps")
@Produces(MediaType.APPLICATION_JSON)
public class Steps {

    @GET
    public static List<Step> index() throws IOException, URISyntaxException {
        return Step.findAll();
    }

    @GET
    @Path("/{id}")
    public static Step getStep(@PathParam("id") String id) throws IOException {
        try {
            return Step.findById(id);
        } catch (FileNotFoundException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}