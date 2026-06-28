package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.FileUploadAttributes;

public class FileUploadTest extends BaseTest {
    @Test(priority=1)
    public void FileUploadTest1() {
        FileUploadAttributes f = new FileUploadAttributes(driver);
        String filePath = "C:\\Users\\shiza\\OneDrive\\Documents\\upload.txt";
        f.selectSingleFile(filePath);
        String file1Path = "C:\\Users\\shiza\\OneDrive\\Documents\\upload.txt";
        String file2Path = "C:\\Users\\shiza\\OneDrive\\Documents\\upload2.txt";


    }

    @Test(priority=2)
    public void FileUploadTest2() {
        FileUploadAttributes f = new FileUploadAttributes(driver);
        String file1Path = "C:\\Users\\shiza\\OneDrive\\Documents\\upload.txt";
        String file2Path = "C:\\Users\\shiza\\OneDrive\\Documents\\upload2.txt";
        f.selectMultipleFiles(file1Path + "\n" + file2Path);
    }
}
