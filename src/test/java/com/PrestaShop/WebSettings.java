package com.PrestaShop;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSettings {
    public WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }
    @After
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }

}
