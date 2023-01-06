package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Challenge {

    WebDriver driver;
    @Before
    public void setUp() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public  void test01(){

//1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//2. Signin buttonuna tiklayin
        //<button id="signin_button" type="button" class="signin btn btn-info">
        //                                <i class="icon-signin"></i>Signin
        //                            </button>

        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

//3. Login alanine  "username" yazdirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
//4. Password alanine "password" yazdirin

        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

//5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();
//6. Online Banking menusunden Pay Bills sayfasina gidin
driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();

driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("500");
//8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("020-09-10");

//9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
//10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
String exceptedMessage= driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
String actualMessage="The payment was successfully submitted.";
        Assert.assertTrue(actualMessage.contains(exceptedMessage));
    }


    //  Can Hoca Cozumu
    /*
    WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
    // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com ");
    //    2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
    //    3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@name='user_login']")).sendKeys("username");
    //    4. Password alanine “password” yazdirin
        driver.findElement(By.cssSelector("#user_password")).sendKeys("password");
    //    5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.navigate().back();
    //    6. Online Banking menusunden Pay Bills sayfasina gidin
​
        driver.findElement(By.cssSelector("#online-banking")).click();
​
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
    //    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("10000");
    //    8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.cssSelector("#sp_date")).sendKeys("2020-09-10");
    //    9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#pay_saved_payees")).click();
    //    10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin
    String successText=driver.findElement(By.cssSelector("#alert_content")).getText();
​
        if (successText.equals("The payment was successfully submitted.")){
        System.out.println("Test PASS");
    }else {
        System.out.println("Test FAIL");
    } */
}
