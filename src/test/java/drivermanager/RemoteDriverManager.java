package drivermanager;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "1");
        sauceOptions.put("name", "Sauce Demo Tests");
        browserOptions.setCapability("sauce:options", sauceOptions);
        try {
            driver = new RemoteWebDriver( new URL("https://oauth-sorokina.eln-8348a:ba5a27a2-2594-421d-a904-88331403e33a@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
