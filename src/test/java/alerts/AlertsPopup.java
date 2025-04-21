package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopup {
    public static void main(String[] args) throws InterruptedException {
        String text = "Arun Kumar A S";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#name")).sendKeys(text);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept(); // only one "OK" button available
        driver.findElement(By.cssSelector("#name")).sendKeys(text);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss(); // here have "OK" and "Cancel" button available
        driver.findElement(By.cssSelector("#name")).sendKeys(text);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
}
