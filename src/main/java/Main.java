import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final int DEFAULT_PORT = 9998;

    public static void main(String[] args) throws IOException {
        final GrizzlyWebServer gws = new GrizzlyWebServer(getPort());

        final ServletAdapter jerseyAdapter = new ServletAdapter(ClassLoader.getSystemResource("static").getFile());
        jerseyAdapter.addInitParameter("com.sun.jersey.config.property.packages", "controllers");
        jerseyAdapter.addInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
        jerseyAdapter.setContextPath("/");
        jerseyAdapter.setHandleStaticResources(true);
        jerseyAdapter.setServletInstance(new ServletContainer());
        gws.addGrizzlyAdapter(jerseyAdapter, new String[] {"/"});

        gws.start();

        logger.log(Level.INFO, "Grizzly started on port: " + gws.getSelectorThread().getPort());
    }

    private static int getPort() {
        return System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : DEFAULT_PORT;
    }
}
