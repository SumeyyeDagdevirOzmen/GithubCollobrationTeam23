package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
  /*
       En temel haliyle otomasyon yapmak icin Class'ımıza otomasyon icin gerekli olan
       webdriver'in yerini goostermemiz gerekir.Bunun icin java kutuphanesinden System.setProperty()
        methodunun icine ilk olarak driver'i yazariz. İkinci olarak driver'in fiziki yolunu kopyalariz
        */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println("Sayfa Basligi: "+ driver.getTitle());
        System.out.println("Sayfa URL = " + driver.getCurrentUrl());
       // System.out.println("driver.getPageSource() = " + driver.getPageSource());
        System.out.println(driver.getWindowHandle()); // Bize o windowa ait hash degerini verir. Biz bu hash degerlerini bit stringe atayip pencereler arasi gecis yaoabiliriz



    }
}
