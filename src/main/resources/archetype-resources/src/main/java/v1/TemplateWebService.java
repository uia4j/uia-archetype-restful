package ${package}.v1;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/template")
public class TemplateWebService extends AbstractWebService {

    private static final Logger LOGGER = LogManager.getLogger(TemplateWebService.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object insert(Object data) {
        LOGGER.info(String.format("[%s][POST] ", tx()));

        return data;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object update(Object data) {
        LOGGER.info(String.format("[%s][PUT] ", tx()));

        return data;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        LOGGER.info(String.format("[%s][DELETE] /%s", tx(), id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Object> queryAll() {
        LOGGER.info(String.format("[%s][GET] ", tx()));

        ArrayList<Object> result = new ArrayList<Object>();

    	return result;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object queryOne(@PathParam("id") String id) {
        LOGGER.info(String.format("[%s][GET] /%s", tx(), id));

        return null;
    }
}
