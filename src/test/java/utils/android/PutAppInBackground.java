package utils.android;

import page.android.BasePage;

import java.time.Duration;

public class PutAppInBackground extends BasePage {
    public void run_app_in_background(){
        getDriver().runAppInBackground(Duration.ofSeconds(30));

    }
}
