package tests.android;

import org.testng.annotations.Test;
import page.android.FormsPage;

public class FormsTest extends BaseTest {
    FormsPage formsPage=new FormsPage();
    @Test
    public void enter_forms(){
        formsPage.click_on_forms_label();
        formsPage.click_on_switch_toggle_btn();
        formsPage.check_toggle_btn_value();
        formsPage.takeScreenShot();
    }
    @Test
    public void select_option_dropdownMenu(){
        formsPage.click_on_forms_label();
        formsPage.click_on_dropdown_menu();
        formsPage.select_the_first_option_dropdownMenu();
        formsPage.takeScreenShot();
    }
    @Test
    public void test_swipe_vertically(){
        formsPage.click_on_forms_label();
        formsPage.swipe_vertical();
        formsPage.takeScreenShot();
    }
}
