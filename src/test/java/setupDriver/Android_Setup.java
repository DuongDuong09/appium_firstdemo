package setupDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.android.BasePage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android_Setup  extends BasePage {

    public static AndroidDriver getAppiumDriver_Android() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getData().getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getData().getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, getData().getProperty("udid"));
            desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            driver.set( new AndroidDriver(appiumServer, desiredCapabilities));
            getDriver().manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDriver();
    }
}
