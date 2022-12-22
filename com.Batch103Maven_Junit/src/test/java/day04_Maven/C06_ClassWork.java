package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
//        - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
//        - Cookies’i kabul edin

        driver.findElement(By.xpath("(//*[@data-cookiebanner='accept_button'])")).click();

//       - “Create an Account” button’una basin

        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

//        - “radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));

//      - Secili degilse cinsiyet butonundan size uygun olani secin

        if(!female.isSelected()) {
            female.click();
        }
        Thread.sleep(3000);
        male.click();
        Thread.sleep(3000);
        custom.click();

    }
}
