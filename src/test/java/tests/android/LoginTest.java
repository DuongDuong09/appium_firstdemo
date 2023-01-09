package tests.android;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test
    public void login_success() {
        loginPage.click_on_login_label();
        loginPage.enter_email_input();
        loginPage.enter_password_input();
        loginPage.click_login_btn();
        loginPage.get_success_title();
    }
}
