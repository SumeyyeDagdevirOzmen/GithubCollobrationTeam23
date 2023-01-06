package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //    -"amazon.com" adresine gidelim
    driver.get("http://www.amazon.com");

//-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    String actualTitle= driver.getTitle();
    String actualUrl=driver.getCurrentUrl();
    System.out.println(actualTitle);
    System.out.println(actualUrl);

//-title ve url'nin "amazon" kelimesinin icerip icermedigini kontrol edelim
    Assert.assertFalse(actualTitle.contains("spend") && actualUrl.contains("spend"));
//            -Ardindan "trendyol.com" adresine gidelim
    driver.get("http://www.trendyol.com");
//-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    String baslik= driver.getTitle();
    Assert.assertFalse(baslik.contains("Sitesi"));
//-Bi onceki web sayfamiza geri donelim
    Thread.sleep(3000);
    driver.navigate().back();
//-sayfayi yenileyelim
    Thread.sleep(3000);
    driver.navigate().refresh();

//-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
    driver.navigate().forward();
    driver.quit(); // Birden fazla sayfada calisilmis ise bu method ile kapatilir


}

}
