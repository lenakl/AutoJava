package com.PrestaShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
    public WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @Test
    public void testLogPos() {
        driver.get("http://prestashop.qatestlab.com.ua/en/");
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.cssSelector("[href=\"http://prestashop.qatestlab.com.ua/en/my-account\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slider_row")));
        driver.findElement(By.id("email_create")).sendKeys("kellja@ukr.net");
        driver.findElement(By.id("SubmitCreate")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitAccount")));
    }

    @Test
    public void testTitle() {
        driver.get("http://prestashop.qatestlab.com.ua/en/");
        String title = driver.getTitle();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(title.equals("http://prestashop.qatestlab.com.ua/"));
        //Assert.assertTrue(title.equals("PrestaShop - онлайн магазин женской одежды"));
    }

    @After
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }
}
