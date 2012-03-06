import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {

    private static final int DEFAULT_PORT = 9998;

    public static void main(String[] args) throws IOException {
        GrizzlyServerFactory.create(getBaseUri(), getResourceConfig());
    }

    private static URI getBaseUri() {
        final int port = System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : DEFAULT_PORT;
        return UriBuilder.fromUri("http://localhost/").port(port).build();
    }

    private static PackagesResourceConfig getResourceConfig() {
        return new PackagesResourceConfig("resources");
    }
}
