package tests.android;

import org.testng.annotations.Test;
import page.android.SwipePage;

public class SwipeTest extends BaseTest {
    SwipePage swipePage=new SwipePage();
    @Test
    public void test_swipe_horizon(){
        swipePage.click_on_swipe_label();
        swipePage.swipe_horizontally();
    }
}
