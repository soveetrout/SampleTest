package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemo {
    ChromeDriver driver = new ChromeDriver();
    @BeforeClass
    void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void getTitleFromPage() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(1000);
        //Assert.assertEquals(driver.getTitle(), "Swag Labs");
        //driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
       // driver.findElement(By.linkText("Sauce Labs Backpack")).click();
        //driver.findElement(By.partialLinkText("Sauce")).click();  //searches by partial text
    //    String a= driver.findElement(By.className("inventory_item_price")).getText();
//        System.out.println(a);

//        List<WebElement> list=driver.findElements(By.partialLinkText("Labs"));
//        list.get(1).click();
//        Thread.sleep(1000);

        List<WebElement> list=driver.findElements((By.tagName("a")));
        int a= list.size();
        System.out.println(a);
    }
    @AfterClass
    void close(){
        driver.close();
    }

}
