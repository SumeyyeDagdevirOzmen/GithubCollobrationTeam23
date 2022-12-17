package day01_DriverMethods;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Amazon sayfasina gidelim
        driver.navigate().to("https://www.amazon.com");
        // Hepsiburada sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().to("http://www.techproeducation.com");
        // Tekrar amazon sayfasina donelim
        Thread.sleep(3000);
        driver.navigate().back(); // Amazon sayfasina geri doner
        // Tekrar hepsuburada sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().forward(); // Techproya gider
        // Son sayfada sayfayi yenileyelim(refresh)
        Thread.sleep(3000);
        driver.navigate().refresh(); // Techpro sayfasini yeniler
        // Ve sayfayi kaptalim
        Thread.sleep(3000);
        driver.close();

    }
}
