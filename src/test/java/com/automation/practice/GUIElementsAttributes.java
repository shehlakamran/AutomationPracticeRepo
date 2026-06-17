package com.automation.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GUIElementsAttributes {
    WebDriver driver;
    public GUIElementsAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(id = "name")
    WebElement txt_name_loc;
    @FindBy(id="email")
    WebElement txt_email_loc;
    @FindBy(id="phone")
    WebElement txt_phone_loc;
    @FindBy(id="textarea")
    WebElement txt_textarea_loc;
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
}