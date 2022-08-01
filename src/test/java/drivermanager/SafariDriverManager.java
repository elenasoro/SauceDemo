package drivermanager;

import org.openqa.selenium.safari.SafariDriver;
import utils.PropertyManager;

public class SafariDriverManager extends DriverManager{


    @Override
    public void createDriver() {
        String path = "PATH_TO_SAFARI_MAC";
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.safari.driver", propertyManager.get(path));
        driver = new SafariDriver();
    }
}
