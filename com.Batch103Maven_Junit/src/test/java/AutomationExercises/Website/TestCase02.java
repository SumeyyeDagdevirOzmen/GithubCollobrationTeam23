package AutomationExercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase02 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() {
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().contains("Automation"));

//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();
//        5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(login.isDisplayed());
//        6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys("sehrigokcan@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys("nemo5775.");

//        7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();
//        8. Verify that 'Logged in as username' is visible
        WebElement logged= driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(logged.isDisplayed());
//        9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
//        10. Verify that 'ACCOUNT DELETED!' is visible


    }
    }
