package record;


import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import org.apache.commons.io.FileUtils;
import page.android.BasePage;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;


public class RecordVideo extends BasePage {
    public void startRecordVideo(){

            getDriver().startRecordingScreen(
                    new AndroidStartScreenRecordingOptions()
                            .withVideoSize("1280x720")
                            .withTimeLimit(Duration.ofSeconds(200)));

    }
    public void stopRecordVideo() throws IOException {
        String video =getDriver().stopRecordingScreen();
        byte[] decode = Base64.getDecoder().decode(video);
        String fileName = "ios.mp4";
        FileUtils.writeByteArrayToFile(new File(fileName), decode);
        getDriver().quit();
    }
}
