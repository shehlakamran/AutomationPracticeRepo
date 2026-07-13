package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaticWebTableAttributes {
    @FindBy(xpath = "//table[@name ='BookTable']//tr")
    public List<WebElement> tablerows;
    @FindBy(xpath = "//table[@name ='BookTable']//tr[1]//th")
    public List<WebElement> tablecolumns;
    @FindBy(xpath = "//table[@name ='BookTable']//tr[5]//td[column]")
    public WebElement data_specificrow;
    WebDriver driver;

    public StaticWebTableAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public int totalRows() {
        return tablerows.size();
    }

    public int totalColumns() {
        return tablecolumns.size();

    }

    public String getCellValue(int row, int column) {
        return driver.findElement(
                By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[" + column + "]")
        ).getText();

    }

    public String getCellDatafromSpecificRow(int row, int column) {
        return driver.findElement(
                By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[" + column + "]")
        ).getText();
    }

}
