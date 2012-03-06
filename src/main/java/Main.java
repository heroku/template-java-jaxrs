import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final int DEFAULT_PORT = 9998;

    public static void main(String[] args) throws IOException {
        final SelectorThread server = GrizzlyServerFactory.create(getBaseUri(), getResourceConfig());
        logger.log(Level.INFO, "Grizzly started on port: " + server.getPort());
    }

    private static URI getBaseUri() {
        final int port = System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : DEFAULT_PORT;
        return UriBuilder.fromUri("http://localhost/").port(port).build();
    }

    private static PackagesResourceConfig getResourceConfig() {
        return new PackagesResourceConfig("resources");
    }
}
