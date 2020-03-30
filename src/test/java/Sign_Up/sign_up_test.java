package Sign_Up;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class sign_up_test {

    private WebDriver driver;

    public void setUp() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","E:/test_automation/resources/geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get("https://phptravels.org/register.php");
        Thread.sleep(5000);
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //--Personal Information---
        driver.findElement(By.id("inputFirstName")).sendKeys("David");
        driver.findElement(By.id("inputLastName")).sendKeys("Harold");
        driver.findElement(By.id("inputEmail")).sendKeys("david.harold@qqmail.com");
        driver.findElement(By.className("selected-dial-code")).click();
        //Used browser Css selector to get this path
        driver.findElement(By.cssSelector("li.country:nth-child(160)")).click();
        driver.findElement(By.id("inputPhone")).sendKeys("08053994122");

        //--Billing Address--
        driver.findElement(By.id("inputCompanyName")).sendKeys("Cool Planet");
        driver.findElement(By.id("inputAddress1")).sendKeys("9a, Firefox valley");
        driver.findElement(By.id("inputAddress2")).sendKeys("Lenovo, Region 2");
        driver.findElement(By.id("inputCity")).sendKeys("Vibranium");
        driver.findElement(By.id("stateinput")).sendKeys("Boogle");
        driver.findElement(By.id("inputPostcode")).sendKeys("100001");
        Select country = new Select(driver.findElement(By.id("inputCountry")));
        country.selectByVisibleText("Nigeria");


        //--Additional Required Information--
        Select findUs = new Select(driver.findElement(By.id("customfield1")));
        findUs.selectByValue("Google");
        driver.findElement(By.id("customfield2")).sendKeys("07065677732");

        //--Account Security--
        driver.findElement(By.id("inputNewPassword1")).sendKeys("sz~c+%RE2Zhp");
        driver.findElement(By.id("inputNewPassword2")).sendKeys("sz~c+%RE2Zhp");

        //Switch mailing list subscription button
        driver.findElement(By.className("bootstrap-switch-label")).click();

        //Click I'm not a robot - the reason why this automation won't work - robot test randomises
        //driver.findElement(By.className("recaptcha-checkbox-border")).click();

        //Click register button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.close();
    }

    public static void main(String args[]) throws InterruptedException
    {
        sign_up_test test = new sign_up_test();
        test.setUp();
    }

}
