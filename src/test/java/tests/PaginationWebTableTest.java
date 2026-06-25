package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PaginationWebTableAttributes;

import java.time.Duration;

public class PaginationWebTableTest {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/#");

    }

    //print all number rows,columns and pages
    @Test(priority = 1)
    public void testPagination() {
        PaginationWebTableAttributes pg = new PaginationWebTableAttributes(driver);
        System.out.println(pg.getTotalRows());
        System.out.println(pg.getTotalColumns());
        System.out.println(pg.getTotalPages());
    }

    //click on all Pages
    @Test(priority = 2)
    public void clickOnAllPages() throws InterruptedException {
        PaginationWebTableAttributes pg = new PaginationWebTableAttributes(driver);
        pg.clickOnPages();

    }

    @Test(priority = 2)
    //print data from all cell
    public void getData() throws InterruptedException {
        PaginationWebTableAttributes pg1 = new PaginationWebTableAttributes(driver);
        int totalPages = pg1.getTotalPages();
        for (int p = 1; p <= totalPages; p++) {
            pg1.clickOnPages();
            int row = pg1.getTotalRows();
            int col = pg1.getTotalColumns();
            System.out.println("Page :" + p);
            for (int r1 = 1; r1 <= row; r1++) {
                for (int c1 = 1; c1 <= col; c1++) {
                    System.out.println(pg1.getCellValue(r1, c1));
                }
                System.out.println();
            }
            System.out.println("\"----- End of Page \" + i + \" -----\")");
        }

    }

    @AfterClass
    public void TearDown() {
        driver.quit();

    }
}
