package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.ShadowDomAttributes;

public class ShadowDomTest extends BaseTest {
    @Test
    public void shadowDomTest() throws InterruptedException {
        ShadowDomAttributes sda = new ShadowDomAttributes(driver);
       // sda.getTextOfShadowDOM();
       // sda.validateLinkMobiles();
        // sda.validateLinkLaptops();
      //  sda.validateBlog();
       // sda.testInputOfBlog();
      //  sda.testCheckBox();
        sda.testUploadFileOption();
    }
}
