package day01_DriverMethods;

import io.netty.util.internal.ThreadExecutorMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01_Work {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Bu method sayfadaki her bir web elementi icin max bekleme suresini belirler.
//        ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
//        oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.

        driver.get("https://www.facebook.com");
        String title= driver.getTitle();
        System.out.println(title.contains("facebook")? "Title Test Passed!": title);

//        Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
//        yazdirin.
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl.contains("facebook")? "Url Test Passed!": actualUrl);

//                https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/"); //driver.navigate().to("https://www.walmart.com/");
//        Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualWalmartTitle=driver.getTitle();
        String expectedWalmartTitle="Walmart.com";
        System.out.println(actualWalmartTitle.contains(expectedWalmartTitle)? "Title2 Test Passed!": "Title2 Test Failed");

//        Tekrar “facebook” sayfasina donun
        Thread.sleep(3000);
        driver.navigate().back();
//        Sayfayi yenileyin
        Thread.sleep(3000);
        driver.navigate().refresh();
//        Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
//        9.Browser’i kapatin
        driver.close();

    }
}
