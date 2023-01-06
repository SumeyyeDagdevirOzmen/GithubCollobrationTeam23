package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
   static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {

        //BeforeClass ile driver ı olusturun ve
//Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setup() throws Exception {
        //http://www.google.com adresine gidin

        driver.get("https://www.google.com");
    }

    @Test
    public void test01() {
//arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();
WebElement arananKutusu= driver.findElement(By.className("gLFyf"));
arananKutusu.sendKeys("The God Father", Keys.ENTER);



//AfterClass ile kapatın

    }

    @Test
    public void test02(){
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

        WebElement arananKutusu= driver.findElement(By.className("gLFyf"));
        arananKutusu.sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void test03(){
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        WebElement arananKutusu= driver.findElement(By.className("gLFyf"));
        arananKutusu.sendKeys("Kill Bill", Keys.ENTER);
    }
    @After
    public void tearDown() throws Exception {
        System.out.println(driver.findElement(By.id("result-stats")).getText().split(" ")[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
