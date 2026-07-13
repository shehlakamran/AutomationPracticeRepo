package tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ActionsAttributes;

public class ActionsTest extends BaseTest {
    @Test(priority=1)
    public void testMouseHover(){
        logger.info("This is mouse hover test");
        ActionsAttributes actionsAttributes = new ActionsAttributes(driver);
        Actions actions = new Actions(driver);
        actionsAttributes.moveToPointMe();
        actionsAttributes.clickLaptops();
    }
    @Test(priority=2)
    public void testDoubleClick(){
        logger.info("This is Double Click test");
        ActionsAttributes actionsAttributes = new ActionsAttributes(driver);
        String entertext =actionsAttributes.enterText("shehla");
        actionsAttributes.clickCopyText();
        Assert.assertEquals(entertext,"shehla");

    }
    @Test(priority=3)
    public void testDragAndDrop(){
        logger.info("This is Drag and Drop test");
        ActionsAttributes actionsAttributes = new ActionsAttributes(driver);
        actionsAttributes.dragAndDrop();

    }
}
