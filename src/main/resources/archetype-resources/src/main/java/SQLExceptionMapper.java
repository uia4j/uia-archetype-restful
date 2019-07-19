package ${package};

import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

    private static final Logger LOGGER = LogManager.getLogger(SQLExceptionMapper.class);

    public SQLExceptionMapper() {
    }

    @Override
    public Response toResponse(SQLException e) {
        LOGGER.error("failed> sql:" + e.getMessage(), e);
        return Response
                .status(Response.Status.EXPECTATION_FAILED)
                .header("Reason", e.getMessage())
                .type("text/plain")
                .build();
    }
}