package tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BrokenLinksAttributes;

import java.io.IOException;
import java.util.Base64;

public class BrokenLinksTest extends BaseTest {
    @Test
    public void getTotalLinks() throws InterruptedException {
        BrokenLinksAttributes brokenLinksAttributes = new BrokenLinksAttributes(driver);
        System.out.println(brokenLinksAttributes.gettotalLinksize());
    }

    @Test(priority = 2)
    public void printAllLinks() throws IOException {
        BrokenLinksAttributes brokenLinksAttributes = new BrokenLinksAttributes(driver);
        brokenLinksAttributes.printAllBrokenLinks();

    }
}
