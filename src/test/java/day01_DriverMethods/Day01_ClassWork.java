package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.Set;

public class Day01_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
//        Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Basligi"+ driver.getTitle());

//        Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle= driver.getTitle();
        if(actualTitle.contains("Amazon")){
            System.out.println("Title testi Passed");
        }else{
            System.out.println("Title testi Failed");
        }
//        Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

//        Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl= driver.getCurrentUrl();
        if(actualTitle.contains("amazon")){
            System.out.println("Url testi Passed");
        }else{
            System.out.println("Url testi Failed");
        }
//  Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
//        Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String sayfaKodlari= driver.getPageSource();
        if(sayfaKodlari.contains("Gateway")){
            System.out.println("Source testi Passed");
        }else{
            System.out.println("Source testi Failed");
        }
//        Sayfayi kapatin.
        driver.close(); //  Sayfayi kapatmak icin close() methodu kullaniriz



    }
}
