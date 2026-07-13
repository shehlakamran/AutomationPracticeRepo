package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FileUploadAttributes {
    WebDriver driver;
    //Locators
    @FindBy(id = "singleFileInput")
    WebElement input_chooseFile;
    @FindBy(xpath = "//button[text()='Upload Single File']")
    WebElement btn_uploadSingleFile;
    @FindBy(id = "singleFileStatus")
    WebElement status_chooseFile;
    @FindBy(id = "multipleFilesInput")
    WebElement input_chooseMultiple;
    @FindBy(id = "multipleFilesStatus")
    List<WebElement> status_chooseMultiple;
    @FindBy(xpath = "//button[text()='Upload Multiple Files']")
    WebElement btn_uploadMultipleFiles;
    public FileUploadAttributes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void selectSingleFile(String path) {
        input_chooseFile.sendKeys(path);
        btn_uploadSingleFile.click();
        //Validate file upload
        String status = status_chooseFile.getText();
        if (status.equalsIgnoreCase("Single file selected: upload.txt, Size: 0 bytes, Type: text/plain")) {
            System.out.println("File upload successfully");
        } else {
            System.out.println("File upload failed");
        }
    }

    public void selectMultipleFiles(String path) {
        input_chooseMultiple.sendKeys(path);
        int numOfFiles = status_chooseMultiple.size();
        int expectedNumOfFiles = 1;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(numOfFiles, expectedNumOfFiles);
        softAssert.assertAll();
       /* if (numOfFiles == 1) {
            System.out.println("Files upload successfully");
        } else {
            System.out.println("Files upload failed");
        }*/
    }
}
