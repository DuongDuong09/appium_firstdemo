package setupDriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.iOS.iOSBasePage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class iOS_Setup extends iOSBasePage {
    public static IOSDriver iosDriver;
    public static IOSDriver getAppiumDriver_IOS() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getData().getProperty("udid"));
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "");
            desiredCapabilities.setCapability("appPackage", "");
            desiredCapabilities.setCapability("appActivity", "");

            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            iosDriver = new IOSDriver(appiumServer, desiredCapabilities);
            iosDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iosDriver;
    }
}
