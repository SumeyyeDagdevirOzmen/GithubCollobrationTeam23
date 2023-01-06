package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/ ");
// Add Element butonuna 100 defa basınız
        for (int i=0; i<100;i++) {
            driver.findElement(By.tagName("button")).click();
        }

// 100 defa basıldığını test ediniz
        List<WebElement> deletes= driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertTrue(deletes.size()==100);

// 90 defa delete butonuna basınız
        for (int i=0; i<90;i++) {
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }

// 90 defa basıldığını doğrulayınız
        List<WebElement> deletes2= driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertTrue(deletes2.size()==10);

// Sayfayı kapatınız
driver.close();
    }
}
