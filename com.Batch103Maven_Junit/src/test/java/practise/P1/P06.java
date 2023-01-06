package practise;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Under the  ORIGINAL CONTENTS click on Alerts
        driver.findElement(By.id("alerts")).click();
        // print the URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        // navigate back
        driver.navigate().back();
        // print the URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        // Click on Basic Ajax
        driver.findElement(By.id("basicajax")).click();
        // print the URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        // enter value-> 20 and Enter
        driver.findElement(By.id("lteq30")).sendKeys("20", Keys.ENTER);
        // and then verify Submitted Values is displayed open page
        String sonuc=driver.findElement(By.tagName("p")).getText();
        System.out.println("sonuc = " + sonuc);
        Assert.assertTrue(sonuc.equals("Submitted Values"));
        // close driver

    }
    @After
    public void tearDown(){
    driver.close();
    }

}
