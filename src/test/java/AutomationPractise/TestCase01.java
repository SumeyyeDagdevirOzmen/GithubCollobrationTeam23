package AutomationPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase01 {
    public static void main(String[] args) {
//        Test Case 1: Register User
//        1. Launch browser
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
       if( driver.getTitle().contains("Automation Exercise"))
           System.out.println("Test Passed");
       else System.out.println("Test Failed");

//        4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

//        5. Verify 'New User Signup!' is visible
        WebElement newUserSignup=driver.findElement(By.xpath("//h2"));
        if (newUserSignup.isDisplayed()){
            System.out.println("New User Signup passed!");
        }else System.out.println("New User Signup Failed");
//        6. Enter name and email address
        WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("sehri");

        WebElement email=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("sehrigokcan@gmail.com");

//        7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enter= driver.findElement(By.xpath("//b"));
        if(enter.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION' is visible");
        } else System.out.println("ENTER ACCOUNT INFORMATION' is NOT visible");

//        9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title= driver.findElement(By.xpath("//input[@value='Mrs']"));
        title.click();
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Nemo5775.");
        WebElement day= driver.findElement(By.xpath("//option[@value='30']"));
        day.click();
        WebElement month= driver.findElement(By.xpath("//option[@value='3']"));
        month.click();
        WebElement year= driver.findElement(By.xpath("//option[@value='1991']"));
        year.click();

//        10. Select checkbox 'Sign up for our newsletter!'
     //   WebElement sign= driver.findElement(By.xpath("//input[@value='1']"));
      //  sign.click();
//        11. Select checkbox 'Receive special offers from our partners!'
     //   WebElement receive= driver.findElement(By.xpath("//input[@name='optin']"));
      //  receive.click();
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName=driver.findElement(By.xpath("//input[@data-qa='first_name']"));
        firstName.sendKeys("Sehri");

        WebElement lastName=driver.findElement(By.xpath("//input[@data-qa='last_name']"));
        lastName.sendKeys("Gokcan");

        WebElement company=driver.findElement(By.xpath("//input[@data-qa='company']"));
        company.sendKeys("TechPro");

        WebElement adres=driver.findElement(By.xpath("//input[@data-qa='address']"));
        adres.sendKeys("Eersel");

        WebElement adres2=driver.findElement(By.xpath("//input[@data-qa='address2']"));
        adres2.sendKeys("Hollanda");

        WebElement country=driver.findElement(By.xpath("//option[@value='United States']"));
        country.click();

        WebElement state=driver.findElement(By.xpath("//input[@data-qa='state']"));
        state.sendKeys("Pensilvanya");

        WebElement city=driver.findElement(By.xpath("//input[@data-qa='city']"));
        city.sendKeys("Pensilvanya");

        WebElement zipcode=driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
        zipcode.sendKeys("5513PH");

        WebElement mnummer=driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
        mnummer.sendKeys("0651932404");


//        13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

//        14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement account=driver.findElement(By.xpath("//b"));
        if(account.isDisplayed()){
            System.out.println("ACCOUNT CREATED!' is visible");
        }else System.out.println("ACCOUNT CREATED!' is NOT visible");
//        15. Click 'Continue' button
        driver.findElement(By.xpath("//button[@data-qa='continue-button']")).click();
//        16. Verify that 'Logged in as username' is visible
        WebElement logged=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        if(logged.isDisplayed()){
            System.out.println("Logged in as username' is visible");
        }else System.out.println("Logged in as username' is NOT visible");
//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleted=driver.findElement(By.xpath("//b"));
        if(deleted.isDisplayed()){
            System.out.println("ACCOUNT DELETED!' is visible");
        }else System.out.println("ACCOUNT DELETED!' is NOT visible");
    }
}
