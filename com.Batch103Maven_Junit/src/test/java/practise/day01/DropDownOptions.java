package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownOptions {


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public  void test01(){
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        //WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        WebElement dropdown=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select options= new Select(dropdown);
        options.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin
        System.out.println(options.getFirstSelectedOption().getText());
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        Assert.assertTrue(options.getOptions().size()==28);
    }

    @After
    public void test02() {
        // driver.close();
    }


}
