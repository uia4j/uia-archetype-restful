package ${package}.v1;

import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/system")
public class SystemWebService extends AbstractWebService {

    public SystemWebService() {
    }

    @GET
    @Path("/version")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object version() {
        return create(
                "name", "RESTful API",
                "version", System.getProperty("version"));
    }

    @GET
    @Path("/test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object test(@PathParam("id") String id, @QueryParam("flag") String flag) {
        return create(
                "id", id,
                "flag", flag);
    }

    private Object create(String... kvs) {
        TreeMap<String, String> result = new TreeMap<String, String>();
        for (int i = 0; i < kvs.length; i += 2) {
            result.put(kvs[i], kvs[i + 1]);
        }
        return result;
    }
}
