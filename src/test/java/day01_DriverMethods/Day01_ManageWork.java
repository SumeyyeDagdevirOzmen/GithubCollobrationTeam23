package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_ManageWork {
    public static void main(String[] args) throws InterruptedException {
//        Amazon soyfasina gidelim. https://www.amazon.com/
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

//        Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin konumu:  " + driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari: "+ driver.manage().window().getSize());
//        Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String position= driver.manage().window().getPosition().toString();
        String size= driver.manage().window().getSize().toString();
//        Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println(position.equals(driver.manage().window().getPosition().toString())
                && size.equals(driver.manage().window().getSize().toString()) ?
                "Test Passed!" : "Test Failed");
//        Sayfayi kapatin
                driver.close();

    }
}
