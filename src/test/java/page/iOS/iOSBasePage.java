package page.iOS;

import data_reader.PropertiesFileReader;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.android.LoginPage;
import record.RecordVideo;
import setupDriver.Android_Setup;
import setupDriver.iOS_Setup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class iOSBasePage {
    public static IOSDriver driver;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    static iOS_Setup iOS_setup = new iOS_Setup();
    public static PropertiesFileReader prop = new PropertiesFileReader();

    RecordVideo recordVideo = new RecordVideo();

    public static Properties getData() throws IOException {
        return prop.FileUpload();
    }

    public LoginPage initDriver(String platform) {
        driver = iOS_setup.getAppiumDriver_IOS();
        recordVideo.startRecordVideo();
        try {
            getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new LoginPage();
    }

    public void tearDown() throws IOException {
        recordVideo.stopRecordVideo();
        driver.quit();
    }

    public void takeScreenShot() {
        File formScreenBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formScreen.png";
        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
