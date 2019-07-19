package ${package};

import javax.ws.rs.core.HttpHeaders;

public interface AppConst {

    public static final String H_APP_SITE = "site";

    public static final String H_APP_USER = "user-id";

    public static String user(HttpHeaders httpHeaders) {
        String id = httpHeaders == null
                ? "NA"
                : httpHeaders.getHeaderString(AppConst.H_APP_USER);
        return id == null ? "NA" : id;
    }

    public static String site(HttpHeaders httpHeaders) {
        String site = httpHeaders == null
                ? "DEV"
                : httpHeaders.getHeaderString(AppConst.H_APP_SITE);
        return site == null ? "DEV" : site;
    }

}
