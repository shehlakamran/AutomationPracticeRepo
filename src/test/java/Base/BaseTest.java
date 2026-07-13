package Base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

public class BaseTest {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"browser"})
    public void SetUp(String br) throws IOException {
        logger = LogManager.getLogger(this.getClass());
        switch (br.toLowerCase()) {
            case "chrome":driver = new ChromeDriver();
            break;
            case "firefox":driver = new FirefoxDriver();
            break;
            case "edge":driver = new EdgeDriver();
            break;
            default:System.out.println("Invalid Browser");
            return;
        }
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        p = new Properties();
        p.load(fis);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("url"));
        logger.info("Browser launched");

    }

    @AfterClass
    public void TearDown() {
        driver.quit();
        LogManager.shutdown();

    }
}
