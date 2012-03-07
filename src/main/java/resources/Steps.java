package resources;

import models.Step;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/steps")
public class Steps {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Step> index() {
        return Arrays.asList(new Step());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Step getStep(@PathParam("id") String id) {
        return new Step(id, id, id);
    }
}