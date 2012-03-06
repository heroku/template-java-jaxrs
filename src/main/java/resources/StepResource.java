package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/steps")
public class StepResource {

    @GET
    @Produces("text/plain")
    public String index() {
        return "1, 2, 3";
    }

    @GET
    @Path("/{id}")
    @Produces("text/plain")
    public String getStep(@PathParam("id") String id) {
        return id;
    }

}
