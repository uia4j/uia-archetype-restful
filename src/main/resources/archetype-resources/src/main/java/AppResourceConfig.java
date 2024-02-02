package ${package};

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class AppResourceConfig extends ResourceConfig {

    public AppResourceConfig() {
        packages("${package}.v1");

        register(SQLExceptionMapper.class);
        register(CommonExceptionMapper.class);
        register(MultiPartFeature.class);

        register(MyContainerResponseFilter.class);
        register(MyContextResolver.class);
        register(MyJacksonFeature.class);
    }
}
