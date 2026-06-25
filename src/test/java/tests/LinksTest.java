package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LinksAttributes;

import java.time.Duration;

public class LinksTest {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/#");

    }

    @Test
    public void linksTest() throws InterruptedException {
        LinksAttributes la = new LinksAttributes(driver);
        la.link_home.click();
        System.out.println(driver.getTitle());
        la.link_courses.click();
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        la.link_onlineTrainings.click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        la.link_blog.click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        la.link_playwright.click();
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void TearDown() {
        driver.quit();

    }
}

