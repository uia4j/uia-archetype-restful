package ${package};

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppListener implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger(AppListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent evt) {
    }

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        ServletContext sc = evt.getServletContext();
        try {
            String appPath = sc.getRealPath("/") + "WEB-INF" + System.getProperty("file.separator") + "app.properties";
            LOGGER.info("properties = " + appPath);

            try (FileInputStream fis = new FileInputStream(appPath)) {
                Properties p = new Properties(System.getProperties());
                p.load(fis);
                System.setProperties(p);
            }

            try {
                LOGGER.info(String.format("version=%s", System.getProperty("version")));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
