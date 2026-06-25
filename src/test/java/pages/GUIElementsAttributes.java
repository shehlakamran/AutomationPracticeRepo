package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GUIElementsAttributes {
    //Locators
    //InputBoxes
    @FindBy(id = "name")
    public WebElement txt_name_loc;
    @FindBy(id = "email")
    public WebElement txt_email_loc;
    @FindBy(id = "phone")
    public WebElement txt_phone_loc;
    @FindBy(id = "textarea")
    public WebElement txt_textarea_loc;
    //RadioButtons
    @FindBy(id = "male")
    public WebElement btn_male_loc;
    @FindBy(id = "female")
    public WebElement btn_female_loc;
    @FindBy(xpath = "button[text()='New Tab']")
    public WebElement btn_new_tab;
    WebDriver driver;
    public GUIElementsAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void setName(String name) {
        txt_name_loc.sendKeys(name);
    }

    public void setEmail(String email) {

        txt_email_loc.sendKeys(email);
    }

    public void setPhone(String phone) {
        txt_phone_loc.sendKeys(phone);
    }

    public void setTextarea(String text) {
        txt_textarea_loc.sendKeys(text);
    }

    public void clickMale() {
        btn_male_loc.click();
    }

    public void clickFemale() {
        btn_female_loc.click();
    }
}