package day04_Maven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class C04_BeforeClassAfterClass {

    /*
        @BeforeClass ve @AfterClass notasyonları sadece static method'lar için çalışır.
    @BeforeClass ve @AfterClass kullanırsak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
    en son @AfterClass'ı çalıştırırız
        Ama sadece @Before ve @After kullanırsak her test için @before ve @after'i kullnır.
     */
    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce çalıştı");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün Testlerden sonra çalıştı");
    }
    @Before
    public void setup01(){
        System.out.println("Her Test'ten önce çalışır");
    }
    @After
    public void teardown01(){
        System.out.println("Her Test'ten sonra çalışır");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }
}
