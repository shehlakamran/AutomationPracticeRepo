package com.automation.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GUIElementsTest {
        WebDriver driver;
        @BeforeClass
        public void SetUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://testautomationpractice.blogspot.com/#");

        }
        @Test
        public void LoginTest(){
            GUIElementsAttributes attributes = new GUIElementsAttributes(driver);
            attributes.setName("shehla");
            attributes.setEmail("sarah786Khan@33");
            attributes.txt_phone_loc.sendKeys("333344445555");
            attributes.txt_textarea_loc.sendKeys("Hello World");
        }
        @AfterClass
        public void TearDown(){
            driver.quit();
            
        }
    }


