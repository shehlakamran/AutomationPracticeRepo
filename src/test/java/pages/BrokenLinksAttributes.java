package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksAttributes {
    WebDriver driver;
    //Attributes
    @FindBy(tagName = "a")
    List<WebElement> links;

    public BrokenLinksAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Method
    public int gettotalLinksize() {
        int totalLinks = links.size();
        return totalLinks;
    }

    public void printAllBrokenLinks() throws IOException {
        for (WebElement link : links) {
            String hrefAttributeValue = link.getAttribute("href");
            if (hrefAttributeValue == null || hrefAttributeValue.isEmpty()) {
                System.out.println("href attribute is empty,so can't find link");
                continue;
            }
            try {
                //convert string values to URL format
                URL linkURL = new URL(hrefAttributeValue);
                //open connection to server
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                //connect to server and send request the server
                conn.connect();
                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefAttributeValue + "==> Broken link");
                } else {
                    System.out.println(hrefAttributeValue + "==> Not a Broken link");
                }

            } catch (Exception e) {
            }
        }

    }
}







