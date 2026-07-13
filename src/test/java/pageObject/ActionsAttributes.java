package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsAttributes {
    WebDriver driver;
    //Constructor
    public ActionsAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(xpath = "//button[text()='Point Me']")
    WebElement button_PointMe;
    @FindBy(xpath = "//*[@id=\"HTML3\"]/div[1]/div/div/a[2]")
    WebElement dd_Laptops;
    @FindBy(xpath = "//button[text()='Copy Text']")
    WebElement button_CopyText;
    @FindBy(id="field1")
    WebElement input_field1;
    @FindBy(id = "draggable")
    WebElement element_drag;
    @FindBy(id="droppable")
    WebElement element_drop;
    //Action Methods
    public void moveToPointMe(){
        Actions actions = new Actions(driver);
        actions.moveToElement(button_PointMe).moveToElement(dd_Laptops).perform();
    }
    public void clickLaptops(){
        Actions actions = new Actions(driver);
        actions.click().perform();
    }
    public void clickCopyText(){
        Actions actions = new Actions(driver);
        actions.contextClick(button_CopyText).perform();
    }
    public String enterText(String text){
        input_field1.clear();
        input_field1.sendKeys(text);
        String textfield1 = input_field1.getAttribute("value");
        return textfield1;

    }
    public void dragAndDrop(){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element_drag,element_drop).perform();
    }
}
