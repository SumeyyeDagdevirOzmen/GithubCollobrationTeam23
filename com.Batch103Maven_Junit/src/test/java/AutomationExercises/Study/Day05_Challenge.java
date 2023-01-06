package AutomationExercises;

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
import java.util.List;

public class Day05_Challenge {


    WebDriver driver;
    @Before
    public void setUp() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void test01(){

//    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
//    ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[@href='http://tutorialsninja.com/demo/index.php?route=product/category&path=24']")).click();
//    ~ get the brandName of phones
        List<WebElement> listBrandNames= driver.findElements(By.tagName("h4"));
        for (WebElement listBrandName : listBrandNames){
            System.out.println(listBrandName.getText());
        }


//    ~ click on add to button for all elements
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[3]")).click();

//    ~ click on black total added cart button
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();


//    ~ get the names of list from the cart
        List<WebElement> namesfromCart= driver.findElements(By.cssSelector("td.text-left>a"));
        for (WebElement w : namesfromCart){
            System.out.println(w.getText());
        }

//    ~ compare the names from displaying list and cart list
        if (namesfromCart.equals(listBrandNames)) {
            System.out.println("Test Passed");
        } else System.out.println("Test Failed");
    }
}
