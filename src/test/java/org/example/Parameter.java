package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String browser,String link)
    {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        driver.get(link);
        driver.manage().window().maximize(); //for window to maximize

    }
    @Test
    public void getTitleFromPage() throws InterruptedException {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
    }
    @AfterClass
    void close(){
        driver.close();
    }
}
