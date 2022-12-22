package day01_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Exercises {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun

        //2- https://www.amazon.com/ adresine gidin
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-”Salesforce Apex Questions Bank” icin arama yapiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Salesforce Apex Questions Bank", Keys.ENTER);
        WebElement aramaSonucYazisi= driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucYazisi.getText());
        //6- Kac sonuc bulundugunu yaziniz
        //7-Sayfayi kapatin
       // driver.close();
    }
}
