package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {

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
        // ...Exercise 1...
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");
        // dropdown'dan "Books" secenegini secin
        WebElement dropbox=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select optionsAll=new Select(dropbox);
        optionsAll.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks");
        //select.selectByIndex(12);

        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin

        WebElement aramaSonucElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucYazısı=aramaSonucElementi.getText();
        Assert.assertTrue(aramaSonucYazısı.contains("Java"));

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
