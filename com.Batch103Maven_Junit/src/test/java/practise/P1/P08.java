package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08 {
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
//        https://www.google.com/ adresine gidin
        driver.get("https://google.com/");
//        cookies uyarisini kabul ederek kapatin
        driver.findElement(By.id("L2AGLb")).click();

//        Sayfa basliginin “Google” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));

//        Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
//        Bulunan sonuc sayisini yazdirin
        String [] sonucSayisi=driver.findElement(By.id("result-stats")).getText().split(" ");
        System.out.println("sonucSayisi[1] = " + sonucSayisi[1]);


//        sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int sonuc= Integer.parseInt(sonucSayisi[1].replaceAll("\\D",""));
        int istenenSayi=10000000;
        Assert.assertTrue(sonuc >istenenSayi);

    }
}
