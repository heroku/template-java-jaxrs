package controllers;

import models.Step;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Path("/steps")
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