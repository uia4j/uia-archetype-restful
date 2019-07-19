package ${package}.v1;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import ${package}.*;

public class AbstractWebService {

    @Context
    private HttpHeaders httpHeaders;

    @Context
    protected HttpServletResponse response;

    protected String getUser() {
        return AppConst.user(this.httpHeaders);
    }

    protected String getSite() {
        return AppConst.site(this.httpHeaders);
    }

    protected String tx() {
        return AppConst.user(this.httpHeaders) + ":" + System.currentTimeMillis() % 3600000;
    }
}
