package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Scanner;

public class LocatorPracticeAdvance {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String userName = "Arun Gowda A S";
        while (true) {
            System.out.println("1: chrome\n2: edge\n3: firefox\n4: exit");
            System.out.println("select the choice");
            int browser = sc.nextInt();
            switch (browser){
                case 1 :
                    WebDriver driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    String password = getPassword(driver);
                    driver.get("https://rahulshettyacademy.com/locatorspractice/");
                    driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys(userName);
                    driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(password);
                    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
                    Thread.sleep(2000);
                    Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello " + userName + ",");
                    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
                    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
                    driver.close();
                    break;
                case 2 :

                    WebDriver driverEdge = new EdgeDriver();
                    driverEdge.manage().window().maximize();
                    driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    String passwordEdge = getPassword(driverEdge);
                    driverEdge.get("https://rahulshettyacademy.com/locatorspractice/");
                    driverEdge.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys(userName);
                    driverEdge.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(passwordEdge);
                    driverEdge.findElement(By.xpath("//button[text()='Sign In']")).click();
                    Thread.sleep(2000);
                    Assert.assertEquals(driverEdge.findElement(By.tagName("h2")).getText(), "Hello " + userName + ",");
                    Assert.assertEquals(driverEdge.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
                    driverEdge.findElement(By.xpath("//button[text()='Log Out']")).click();
                    driverEdge.close();
                    break;

                case 3:

                    WebDriver driverFire = new FirefoxDriver();
                    driverFire.manage().window().maximize();
                    driverFire.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    String passwordFire = getPassword(driverFire);
                    driverFire.get("https://rahulshettyacademy.com/locatorspractice/");
                    driverFire.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys(userName);
                    driverFire.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(passwordFire);
                    driverFire.findElement(By.xpath("//button[text()='Sign In']")).click();
                    Thread.sleep(2000);
                    Assert.assertEquals(driverFire.findElement(By.tagName("h2")).getText(), "Hello " + userName + ",");
                    Assert.assertEquals(driverFire.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
                    driverFire.findElement(By.xpath("//button[text()='Log Out']")).click();
                    driverFire.close();
                    break;
                case 4 :
                    System.out.println("Thank You!!! - Closed");
                    System.exit(0);
                    break;
            }

        }

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div[contains(@class,'forgot-pwd-container')]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        String passwordText = driver.findElement(By.cssSelector("p[class*='info']")).getText();
//        Please use temporary password 'rahulshettyacademy' to Login.
        String[] splitArr = passwordText.split("'");
        String password = splitArr[1].split("'")[0];
        return password;

    }
}
