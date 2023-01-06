package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

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
            //https://id.heroku.com/login sayfasina gidin
            driver.get("https://id.heroku.com/login ");
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            //Bir mail adersi giriniz
            driver.findElement(By.id("email")).sendKeys("sehrigokcan@gmail.com", Keys.TAB,"Nemo5775.",Keys.ENTER);
            //Bir password giriniz
            //Login butonuna tiklayiniz
            //"There was a problem with your login." texti gorunur ise
            WebElement problem=driver.findElement(By.xpath("//*[@class='alert alert-danger']"));
            if (problem.isDisplayed()){ // (problem.getText().equals("There was a problem with your login."))
                System.out.println("kayit yapilamadi");
            }
            else System.out.println("kayit yapildi");
            //"kayit yapilamadi" yazdiriniz
            //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
            //sayfayı kapatiniz
            driver.close();

        }
        @After
        public void tearDown(){

        }


}
