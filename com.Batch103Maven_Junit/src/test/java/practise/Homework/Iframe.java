package practise.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeOdev extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //    Bir class olusturun: IframeOdev
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe ");
//    sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> list=driver.findElements(By.tagName("iframe"));
        // driver.findElements(By.xpath("//iframe");
        System.out.println("IFrame sayisi"+ list.size());
//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualYazi= driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(actualYazi.contains("Editor"));
//    Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement frame= driver.findElement(By.tagName("p"));
        frame.clear();
        Thread.sleep(3000);
//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        frame.sendKeys("iframein icindeyim");
//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String actualFooter= driver.findElement(By.xpath("//div[@class='large-4 large-centered columns']")).getText();
        Assert.assertTrue(actualFooter.contains("Elemental Selenium"));
    }

}
