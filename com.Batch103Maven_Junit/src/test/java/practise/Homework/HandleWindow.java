package practise.Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class HandleWindowHuiswerk extends TestBase {
    @Test
    public void handleWindowTest() {
//        https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String window1Handle=driver.getWindowHandle();
//        Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals(driver.getTitle(),"Windows");
//        Click here a tiklayin
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
 //    Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> allWindowHandles = driver.getWindowHandles();
        allWindowHandles.stream().filter(t-> !t.equals(window1Handle)).forEach(t->driver.switchTo().window(t));
        Assert.assertEquals(driver.getTitle(),"New Window");


    }
}
