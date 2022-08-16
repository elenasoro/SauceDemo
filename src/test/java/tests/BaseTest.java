

package tests;

import drivermanager.DriverType;
import drivermanager.threadlocalmanager.DriverThreadLocalManager;
import drivermanager.threadlocalmanager.DriverThreadLocalManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseTest {

    DriverThreadLocalManager driverManager;

    @BeforeClass
    @Parameters({"browser"})
    public void createManager(@Optional("chrome") String browser) {
        DriverType type = null;
        if(browser.equals("chrome")){
            type = DriverType.CHROME;
        } else if(browser.equals("safari")) {
            type = DriverType.SAFARI;
        }
        DriverThreadLocalManagerFactory factory = new DriverThreadLocalManagerFactory();
        driverManager = factory.getManager(type);
    }

    @BeforeMethod
    public void setUp() {

        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.getDriver().quit();
    }
}