package AutomationExercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day07_Challenge {
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
//    Given kullanici "https://editor.datatables.net/" sayfasina gider
    driver.get("https://editor.datatables.net/");
//    Then new butonuna basar
driver.findElement(By.xpath("//*[text()='New']")).click();
//    And editor firstname kutusuna "<firstName>" bilgileri girer
driver.findElement(By.id("DTE_Field_first_name")).sendKeys("sehri");
//    And editor lastname kutusuna "<lastName>" bilgileri girer
        driver.findElement(By.id("DTE_Field_last_name")).sendKeys("gokcan");
//    And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.id("DTE_Field_position")).sendKeys("automation");
//    And editor office kutusuna "<office>" bilgileri girer
        driver.findElement(By.id("DTE_Field_office")).sendKeys("hollanda");
//    And editor extension kutusuna "<extension>" bilgileri girer
        driver.findElement(By.id("DTE_Field_extn")).sendKeys("ext");
//    And editor startdate kutusuna "<startDate>" bilgileri girer
        driver.findElement(By.id("DTE_Field_start_date")).sendKeys("2022-12-23");
//    And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.id("DTE_Field_salary")).sendKeys("70000");
//    When Create tusuna basar
        driver.findElement(By.xpath("//*[text()='Create']")).click();
//    Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("sehri");
        String isimSoyisim= driver.findElement(By.xpath("//*[@class='sorting_1']")).getText();
        Assert.assertTrue(isimSoyisim.contains("sehri"));

//    And Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[@class='sorting_1']")).click();
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();

//    Then Kullanıcinin silindiğini doğrular.

        String silMesaji=  driver.findElement(By.className("dataTables_empty")).getText();
        Assert.assertTrue(silMesaji.contains("No matching records found"));

    }

}
