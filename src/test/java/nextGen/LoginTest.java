package nextGen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        String userName = "admin";
        String password = "1234";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://192.168.0.135/Battery/default.aspx");
        Select dropdown = new Select(driver.findElement(By.id("CboFacilities")));
        dropdown.selectByValue("1");
        driver.findElement(By.id("txtUserId")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("btnOk")).click();
        Thread.sleep(2000);
//        Thread.sleep(10000);
        driver.switchTo().frame("Content");
//        driver.findElement(By.cssSelector("div[class='modalPopupButtWrapper'] img")).click();
        // Below code handle YES or NO option
        driver.switchTo().frame("ifrmPopModal");
        driver.findElement(By.xpath("//input[@id='rblLetters_1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnOk']")).click();

//        driver.findElement(By.cssSelector("#TabControl1_t7_")).click();
    }

}
