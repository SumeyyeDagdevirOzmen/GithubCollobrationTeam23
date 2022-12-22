package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle= driver.getTitle();
        if (actualTitle.contains("Spend less")){
            System.out.println("Test Passed!");
        }else System.out.println("Test Failed!");

        //Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc\']")).click();
        //Birthday butonuna basin
        /*
        <img src="https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png"
        alt="Birthday">
         */
        driver.findElement(By.cssSelector("img[alt='Birthday']")).click();

        //Best Seller bolumunden ilk urunu tiklayin

        List<WebElement> bestsellers= driver.findElements(By.cssSelector("img[alt='Amazon.com eGift Card']"));
        bestsellers.get(0).click();
          /*
        <img alt="Amazon.com eGift Card" src="https://images-na.ssl-images-amazon.com/images/I/51f+fN6y6QL._AC_SX184_.jpg"
        data-a-hires="https://images-na.ssl-images-amazon.com/images/I/51f+fN6y6QL._AC_SX368_.jpg">
         */

        //Gift card details’den 25 $’i secin
        driver.findElement(By.cssSelector("span[id='a-autoid-28']")).click();

        //Urun ucretinin 25$ oldugunu test edin
        WebElement urunUcreti=driver.findElement(By.cssSelector("span[id='gc-live-preview-amount']"));
        if (urunUcreti.getText().equals("$25.00")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        // Sayfayi kapatin
        driver.close();





    }
}
