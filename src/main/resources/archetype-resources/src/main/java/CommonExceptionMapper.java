package ${package};

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class CommonExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LogManager.getLogger(CommonExceptionMapper.class);

    public CommonExceptionMapper() {
    }

    @Override
    public Response toResponse(Exception e) {
        LOGGER.error("failed> " + e.getMessage(), e);
        return Response
                .status(Response.Status.EXPECTATION_FAILED)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse("generic", e.getMessage()))
                .build();
    }
}