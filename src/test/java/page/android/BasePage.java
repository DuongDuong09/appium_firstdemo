package page.android;

import data_reader.PropertiesFileReader;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import record.RecordVideo;
import setupDriver.Android_Setup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    public static WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(30));
    static Android_Setup android_setup = new Android_Setup();
    public static PropertiesFileReader prop = new PropertiesFileReader();
    public static AndroidDriver getDriver() {
        return driver.get();
    }
    RecordVideo recordVideo = new RecordVideo();

    public static Properties getData() throws IOException {
        return prop.FileUpload();
    }

    public AndroidDriver initDriver() {
        android_setup.getAppiumDriver_Android();
        recordVideo.startRecordVideo();
        try {
            getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getDriver();
    }

    public void tearDown() throws IOException {
        recordVideo.stopRecordVideo();
        getDriver().quit();
    }

    public void takeScreenShot() {
        File formScreenBase64Data = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formScreen.png";
        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

