package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksAttributes {
    //Locators
    @FindBy(xpath = "//*[text()='Home']")
    public WebElement link_home;
    @FindBy(xpath = "//*[text()='Udemy Courses']")
    public WebElement link_courses;
    @FindBy(xpath = "//*[text()='Online Trainings']")
    public WebElement link_onlineTrainings;
    @FindBy(xpath = "//*[text()='Blog']")
    public WebElement link_blog;
    @FindBy(xpath = "//*[text()='PlaywrightPractice']")
    public WebElement link_playwright;
    WebDriver driver;
    public LinksAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void home() {
        link_home.click();
    }

    public void courses() {
        link_courses.click();
    }

    public void onlineTrainings() {
        link_onlineTrainings.click();
    }

    public void blog() {
        link_blog.click();
    }

    public void playwrightPractice() {
        link_playwright.click();
    }

}
