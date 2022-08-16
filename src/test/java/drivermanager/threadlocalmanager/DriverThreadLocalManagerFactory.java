package drivermanager.threadlocalmanager;

import drivermanager.DriverType;

public class DriverThreadLocalManagerFactory {

    public DriverThreadLocalManager getManager(DriverType driverType) {

        DriverThreadLocalManager driverThreadLocalManager;

        switch (driverType) {
            case CHROME:
                driverThreadLocalManager = new ChromeDriverThreadLocalManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type " + driverType);
        }
        return driverThreadLocalManager;
    }
}