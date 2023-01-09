package tests.android;
import extent_report.ExtentReport;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.android.BasePage;
import page.android.LoginPage;

import java.io.IOException;

public class BaseTest extends ExtentReport {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void setupDriver(){
        basePage.initDriver();
    }

    @AfterTest
    public void tearDown() throws IOException {
        basePage.tearDown();
    }
}

