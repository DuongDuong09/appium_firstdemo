package utils.android;

import org.openqa.selenium.NotFoundException;
import page.android.BasePage;

public class InteractMultipleApp extends BasePage {
    public void interact_multiple_application(){
        getDriver().activateApp("com.android.settings");
        getDriver().findElementByXPath("//*[@text='Wi-Fi']").click();
        try{
            boolean isWifiOn=getDriver().findElementByXPath("//*[@text='On']").isDisplayed();
        }catch (NotFoundException notFoundException){
            notFoundException.printStackTrace();
        }
    }
}
