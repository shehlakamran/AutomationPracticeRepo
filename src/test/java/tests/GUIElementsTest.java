package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.GUIElementsAttributes;

public class GUIElementsTest extends BaseTest {

    @Test
    public void LoginTest() {
        GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
        attributes.setName("shehla");
        attributes.setEmail("sarah786Khan@33");
        attributes.txt_phone_loc.sendKeys("333344445555");
        attributes.txt_textarea_loc.sendKeys("Hello World");
        attributes.btn_male_loc.click();
        attributes.btn_female_loc.click();
    }

}


