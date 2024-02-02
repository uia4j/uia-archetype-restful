package ${package};

import java.io.FileInputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
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
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            }
            catch (Exception e) {
            }
        }
        LOGGER.info("APP> destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        ServletContext sc = evt.getServletContext();
        try {
            String appPath = sc.getRealPath("/") + "WEB-INF" + System.getProperty("file.separator") + "app.properties";
            LOGGER.info("APP> properties = " + appPath);

            try (FileInputStream fis = new FileInputStream(appPath)) {
                Properties p = new Properties(System.getProperties());
                p.load(fis);
                p.load(AppListener.class.getResourceAsStream("/pom.properties"));
                System.setProperties(p);
            }

            LOGGER.info(String.format("APP> version=%s", System.getProperty("app.version")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
