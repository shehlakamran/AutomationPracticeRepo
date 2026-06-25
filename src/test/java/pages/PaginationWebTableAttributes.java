package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaginationWebTableAttributes {
    //Locators
    @FindBy(xpath = "//ul[@id='pagination']//a")
    public List<WebElement> link_pages;
    @FindBy(xpath = "//table[@id='productTable']//tr")
    public List<WebElement> rows_table;
    @FindBy(xpath = "//table[@id='productTable']//tr[1]//th")
    public List<WebElement> columns_table;
    WebDriver driver;
    public PaginationWebTableAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public int getTotalPages() {
        return link_pages.size();
    }

    public int getTotalRows() {
        return rows_table.size();
    }

    public int getTotalColumns() {
        return columns_table.size();
    }

    public void clickOnPages() throws InterruptedException {
        for (int i = 1; i < link_pages.size(); i++) {
            link_pages.get(i).click();
            Thread.sleep(3000);
            System.out.println("Link page" + i + " clicked");
        }
    }

    public String getCellValue(int row, int col) {
        return driver.findElement(
                org.openqa.selenium.By.xpath("//table[@id='productTable']//tbody//tr[" + row + "]//td[" + col + "]")
        ).getText();
    }

}






