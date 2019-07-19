package ${package};

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api/v1")
public class AppResourceConfig extends ResourceConfig {

    public AppResourceConfig() {
        packages("${package}.v1");

        register(SQLExceptionMapper.class);

        register(MyContainerResponseFilter.class);
        register(MyContextResolver.class);
        register(MyJacksonFeature.class);
    }
}
