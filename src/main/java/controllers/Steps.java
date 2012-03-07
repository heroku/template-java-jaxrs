package controllers;

import models.Step;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Path("/steps")
public class Steps {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Step> index() throws IOException, URISyntaxException {
        return Step.fromAllFiles();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Step getStep(@PathParam("id") String id) throws IOException {
        return Step.fromFile(id);
    }
}