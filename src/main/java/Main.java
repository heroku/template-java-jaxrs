import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final int DEFAULT_PORT = 9998;

    public static void main(String[] args) throws IOException {
        final SelectorThread server = GrizzlyWebContainerFactory.create(getBaseUri(), getInitParams());
        logger.log(Level.INFO, "Grizzly started on port: " + server.getPort());
    }

    private static URI getBaseUri() {
        final int port = System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : DEFAULT_PORT;
        return UriBuilder.fromUri("http://localhost/").port(port).build();
    }

    private static Map<String, String> getInitParams() {
        final Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("com.sun.jersey.config.property.packages", "controllers");
        initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        return initParams;
    }
}
