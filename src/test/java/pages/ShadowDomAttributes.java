package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShadowDomAttributes {
    WebDriver driver;
    //Locators
    @FindBy(xpath = "//h2[text()='ShadowDOM']")
    WebElement shadowdom;
    @FindBy(id = "shadow_host\"")
    WebElement shadowhost1;
    @FindBy(id = "nested_shadow_host")
    WebElement shadowhost2;
    @FindBy(xpath = "//a[text()='Blog']")
    WebElement blog;

    public ShadowDomAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public String getTextOfShadowDOM() {
        String text = shadowdom.getText();
        if (text.equals("ShadowDOM")) {
            System.out.println("ShadowDOM found");
        } else {
            System.out.println("ShadowDOM not found");
        }
        return text;
    }

    public void validateLinkMobiles() throws InterruptedException {
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement link_Mobile = shadow.findElement(By.cssSelector(".info"));
        link_Mobile.click();
        Boolean status = link_Mobile.isSelected();
        if (status == true) {
            System.out.println("Mobile link selected");
        } else {
            System.out.println("Mobile link is not working");
        }

    }

    public void validateLinkLaptops() throws InterruptedException {
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#nested_shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement link_Laptops = shadow1.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(1)"));
        link_Laptops.click();
        Boolean status = link_Laptops.isSelected();
        if (status == true) {
            System.out.println("Laptop link selected");
        } else {
            System.out.println("Laptop link is not working");
        }
    }


    public void validateBlog() throws InterruptedException {
        blog.click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        if (title.equals("SDET-QA Blog")) {
            System.out.println("Blog found");
        } else {
            System.out.println("Blog not found");
        }
        driver.navigate().back();
        Thread.sleep(5000);
    }


    public void testInputOfBlog() throws InterruptedException {
        WebElement shadow = driver.findElement(By.cssSelector("#shadow_host"));
        SearchContext sc1 = shadow.getShadowRoot();
        WebElement el = sc1.findElement(By.cssSelector("#nested_shadow_host"));
        WebElement ele = sc1.findElement(By.cssSelector("input[type=text]:nth-child(5)"));
        Thread.sleep(5000);
        ele.click();
        ele.sendKeys("shehla");
    }

    public void testCheckBox() throws InterruptedException {
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement checkbox = shadow.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();
        boolean checked = checkbox.isSelected();
        System.out.println("checkbox checked: " + checked);

    }
    public void testUploadFileOption() throws InterruptedException {
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
        Thread.sleep(1000);
        WebElement upload = shadow.findElement(By.cssSelector("input[type=file]:nth-child(9)"));
        upload.sendKeys("C:\\Users\\shiza\\OneDrive\\Documents\\upload.txt");
        int numOfFile = driver.findElements(By.cssSelector("input[type=file]:nth-child(9)")).size();



    }


}



