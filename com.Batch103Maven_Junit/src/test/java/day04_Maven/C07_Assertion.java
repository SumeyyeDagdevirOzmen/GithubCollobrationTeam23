package day04_Maven;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com ");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
         driver.close();
    }
//2)https://www.amazon.com adresinegidin
//            3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
//○ title Test  => Sayfa başlığının “YouTube” oldugunu testedin
//○ image Test => YouTube resminin görüntülendiğini (isDisplayed()) testedin
//○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
// ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void test01() {
        String actualTitle= driver.getTitle();
        String expectedTitle= "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void test02() {
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
//                if(!sayfaResim.isDisplayed()) {
//                    System.out.println("Test Passed!");
//                }else System.out.println("Test Failed!");
    }
    @Test
    public void test03(){
        WebElement searchBox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void test04() {
        String actualTitle= driver.getTitle();
        String expectedTitle= "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
}

