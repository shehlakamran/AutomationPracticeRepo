package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsAndPopUps {
    WebDriver driver;
    //Locators
    @FindBy(id = "alertBtn")
    WebElement button_simpleAlert;
    @FindBy(id = "confirmBtn")
    WebElement button_ConfirmationAlert;
    @FindBy(id = "promptBtn")
    WebElement button_PromptAlert;
    @FindBy(id = "demo")
    WebElement message_Alert;

    public AlertsAndPopUps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public String getTextOfMessage() {
        String actual = message_Alert.getText();
        return actual;
    }

    public void clickOnSimpleAlert() {
        button_simpleAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
    }

    public void clickOnConfirmationAlert() {
        button_ConfirmationAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();


    }

    public void clickOnPromptAlert() {
        button_PromptAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        alert.sendKeys(String.valueOf(Keys.DELETE));
        alert.sendKeys("Shehla");
        alert.accept();


    }

}
