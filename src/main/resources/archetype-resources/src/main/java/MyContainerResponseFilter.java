package ${package};

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;

public final class MyContainerResponseFilter implements ContainerResponseFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, X-Codingpedia, Authorization");
        headers.add("Access-Control-Expose-Headers", "Reason, Authorized");
        headers.add("Access-Control-Credentials", "true");

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate, private, s-maxage=0");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", 0);
    }
}
