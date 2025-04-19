package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        driver.navigate().to("https://rahulshettyacademy.com/client/");
        Thread.sleep(1000);
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/");
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        driver.close();
    }
}
