package nextGen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        String userName = "himanth";
        String password = "Global@123";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qaone.ssm-erp.com/");
        driver.findElement(By.xpath("//input[contains(@name,'Username')]")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//i[@class='nav-prospect']")).click();
        driver.findElement(By.id("newstore")).click();
    }

}
