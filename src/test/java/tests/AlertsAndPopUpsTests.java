package tests;

import Base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AlertsAndPopUps;

public class AlertsAndPopUpsTests extends BaseTest {
    @Test(priority = 1)
    public void testSimpleAlert() {
        AlertsAndPopUps ap = new AlertsAndPopUps(driver);
        ap.clickOnSimpleAlert();
    }

    @Test(priority = 2)
    public void testConfirmationAlert() {
        AlertsAndPopUps ap = new AlertsAndPopUps(driver);
        ap.clickOnConfirmationAlert();
        String expectedText = "You pressed Cancel!";
        ap.getTextOfMessage();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(ap.getTextOfMessage(), expectedText);
        System.out.println(ap.getTextOfMessage());
        sa.assertAll();
    }

    @Test(priority = 3)
    public void testConfirmationAlert2() {
        AlertsAndPopUps ap = new AlertsAndPopUps(driver);
        ap.clickOnConfirmationAlert();
        String expectedText = "You pressed Cancel!";
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(ap.getTextOfMessage(), expectedText);
        System.out.println(ap.getTextOfMessage());
        sa.assertAll();


    }

}
