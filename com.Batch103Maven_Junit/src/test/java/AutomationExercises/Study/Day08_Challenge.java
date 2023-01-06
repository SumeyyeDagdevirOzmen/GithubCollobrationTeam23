package AutomationExercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day08_Challenge {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test()
    {

//1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/ ");
//2-"BOOKS" başlığının görünür olduğunu doğrulayın
//        WebElement books= driver.findElement(By.xpath("//*[text()='BOOKS']"));
//        Assert.assertTrue(books.isDisplayed());
////3-Arama çubuğunda "Selenium" u aratın.
//       // driver.findElement(By.cssSelector("#input")).sendKeys("Selenium");
//        SearchContext shadow2 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
//        shadow2.findElement(By.cssSelector("#input")).sendKeys("Selenium", Keys.ENTER);
//
////4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
//        SearchContext shadow3 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
//        SearchContext shadow4 = shadow3.findElement(By.cssSelector("book-explore[class='_page']")).getShadowRoot();
//
//        SearchContext shadow5 = shadow4.findElement(By.cssSelector(" section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)")).getShadowRoot();
//
//        WebElement product1 = shadow5.findElement(By.cssSelector(".title"));
       // Assert.assertTrue(product1.getText().contains("Selenium"));
    }

    @Test
    public void test02() {
//        driver.get("https://books-pwakit.appspot.com/ ");
//
//        WebElement shadowHost= driver.findElement(By.tagName("book-app"));
//
//        JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
//       WebElement shadowRoot= (WebElement) jsExecutor.executeScript(
//                "return arguments[0].shadowRoot, shadowHost"
//        );
//
//       WebElement app_header= shadowRoot.findElement(By.tagName("app-header"));
//        WebElement app_toolbaar= app_header.findElement(By.cssSelector(".toolbar-bottom"));
//        WebElement book_input_decorator=app_header.findElement(By.tagName("book-input-decorator"));
//        WebElement searchField= book_input_decorator.findElement(By.id("input"));
//        searchField.sendKeys("Shadow DOM With Find Element");
    }

    @Test
    public void test03(){
        JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
        WebElement bookSearchField= (WebElement) jsExecutor.executeScript(
                "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
        bookSearchField.sendKeys("Shadow DOM Without Find Element");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }
}
