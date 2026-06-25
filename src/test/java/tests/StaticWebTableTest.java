package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class StaticWebTableTest {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/#");

    }

/*    @Test(priority = 1)
    public void getTotalRows() {
        StaticWebTableAttributes sa = new StaticWebTableAttributes(driver);
        System.out.println(sa.totalRows());
    }

    @Test(priority = 2)
    public void getTotalColumns() {
        StaticWebTableAttributes sa = new StaticWebTableAttributes(driver);
        System.out.println(sa.totalColumns());
    }

    @Test(priority = 3)
    public void printData() {
        StaticWebTableAttributes sa = new StaticWebTableAttributes(driver);
        int rows = sa.totalRows();
        int columns = sa.totalColumns();
        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                System.out.println(sa.getCellValue(r, c) + "--- ");

            }
            System.out.println();

        }
    }




    @AfterClass
    public void TearDown() {
        driver.quit();

    }*/


}

