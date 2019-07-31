package ${package}.v1;

import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/system")
public class SystemWebService extends AbstractWebService {

    private static final Logger LOGGER = LogManager.getLogger(SystemWebService.class);

    public SystemWebService() {
    }

    @GET
    @Path("/version")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object version() {
        String tx = tx();
        LOGGER.info(String.format("[%s][GET] v1/system/version", tx));

        return create(
                "name", "RESTful API",
                "version", System.getProperty("version"));
    }

    @GET
    @Path("/test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object test(@PathParam("id") String id, @QueryParam("flag") String flag) {
        String tx = tx();
        LOGGER.info(String.format("[%s][GET] v1/system/test/%s?flag=%s", tx, id, flag));

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
