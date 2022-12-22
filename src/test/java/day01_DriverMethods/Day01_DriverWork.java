package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_DriverWork {
    public static void main(String[] args) {
//        Youtube ana sayfasina gidelim . https://www.youtube.com/
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");

//        Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

//        Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
//        Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
//        Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
//        Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();
    }
}
