package tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.GUIElementsAttributes;

public class JavascriptExecutorTest extends BaseTest {
    //How to use JavascriptExecutor Interface for action method -- click()
    WebDriver driver;


    @Test(priority = 1)
    public void sendKeysByJavascript() {
        GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','shehla')", attributes.txt_name_loc);
    }

    @Test(priority = 2)
    //click by JavaExecutorScript
    public void clickByJavascript() {
        GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", attributes.btn_male_loc);
        System.out.println(js.executeScript("return window.pageYOffset;"));

    }

    @Test(priority = 3)
    //scroll By JavascriptExecutor
    public void scrollByJavascript() {
        GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 3000);");
        // Print actual scroll position
        System.out.println(js.executeScript("return window.pageYOffset;"));

    }

    @Test(priority = 4)
    //scroll till the end of the page
    public void scrollTillEndOfPage() {
        GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
        System.out.println(js.executeScript("return window.pageYOffset;"));
    }

    @Test(priority = 5)
    //scroll to original Position
    public void scrollToOriginalPosition() {
        GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
        System.out.println(js.executeScript("return window.pageYOffset;"));
    }

    @AfterClass
    public void TearDown() {
        driver.quit();

    }
}
