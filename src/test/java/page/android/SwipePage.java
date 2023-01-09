package page.android;

import org.openqa.selenium.By;
import utils.android.MobileAction;

public class SwipePage extends BasePage {
    MobileAction mobileAction=new MobileAction();
    By swipeLabel = By.id("Swipe");
    By swipeHorizontal = By.xpath("//*[@text='Swipe horizontal']");

    public void click_on_swipe_label() {
        if (getDriver().findElement(swipeLabel).isDisplayed()) {
            getDriver().findElement(swipeLabel).click();
        }
    }

    public void swipe_horizontally() {
        mobileAction.horizontalSwipeByPercentage(0.9,0.5,0.7);
    }
}
