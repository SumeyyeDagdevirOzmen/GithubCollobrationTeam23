package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day09_Challange {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test()
    {
//        1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement menu= driver.findElement(By.id("dropdown-class-example"));
        Assert.assertTrue(menu.isDisplayed());

//        3-Option3 ü seçin.
        Select options=new Select(menu);
        options.selectByIndex(3);
//        4-Option3 ün seçili olduğunu doğrulayın.
        Assert.assertEquals(options.getFirstSelectedOption().getText(),"Option3");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
         driver.quit();
    }
}
