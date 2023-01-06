package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_Challenge {

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
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

//2. Username kutusuna "standard_user" yazdirin
driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//3. Password kutusuna "secret_sauce" yazdirin
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

//4. Login tusuna basin
driver.findElement(By.xpath("//input[@id='login-button']")).click();

//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrunIsim= driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
  //      driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).click();

//6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
//         driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String secilenUrunIsim= driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
//         String sepetKontrol= driver.findElement(By.id("item_4_title_link")).getText();
        Assert.assertEquals(secilenUrunIsim,ilkUrunIsim);


    }
}
