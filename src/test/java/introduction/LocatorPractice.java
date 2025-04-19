package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        String userName = "Arun Gowda A S";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Arun@so.com");
        driver.findElement(By.xpath("//form/input[2]")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Arun.12@gmail.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("2569852569");
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        String resetData = driver.findElement(By.cssSelector("form p")).getText();
        String actualPassword = getPassword(resetData);
        driver.findElement(By.xpath("//form/div/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(actualPassword);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(3000);
        String welcomeData = driver.findElement(By.xpath("//div/h2")).getText();
        String confirmData = driver.findElement(By.cssSelector("div p")).getText();
        String actualUser = getUserName(welcomeData);
        Assert.assertEquals(welcomeData, "Hello "+userName+",");
        Assert.assertEquals(confirmData, "You are successfully logged in.");
        driver.findElement(By.cssSelector("button[class='logout-btn']")).click();

        driver.close();

    }

    public static String getPassword(String key) {
        String[] splitData = key.split("'");
        System.out.println(splitData[1].split("'")[0]);
        return splitData[1].split("'")[0];
    }

    public static String getUserName(String key) {
        String[] splitData = key.split(" ");
        System.out.println(splitData[1].split(",")[0]);
        return splitData[1].split(",")[0];
    }
}
