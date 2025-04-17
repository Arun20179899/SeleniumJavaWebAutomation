package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Scanner;

public class SeleniumWebDriverConcept {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1: chrome\n2: edge\n3: firefox\n4: exit");
            System.out.println("select the choice");
            int browser = sc.nextInt();
            switch (browser) {
                case 1:
                    WebDriver driverChrome = new ChromeDriver();
                    driverChrome.manage().window().maximize();
                    driverChrome.get("https://rahulshettyacademy.com/");
//        System.out.println("Title: "+driver.getTitle());
//        System.out.println("Current Url: "+driver.getCurrentUrl());
                    Assert.assertEquals("https://rahulshettyacademy.com/", driverChrome.getCurrentUrl());
                    Assert.assertEquals("Selenium, API Testing, Software Testing & More QA Tutorials | Rahul Shetty Academy", driverChrome.getTitle());
                    driverChrome.close();
                    break;
                case 2:
                    WebDriver driverEdge = new EdgeDriver();
                    driverEdge.manage().window().maximize();
                    driverEdge.get("https://rahulshettyacademy.com/loginpagePractise/");
//        System.out.println("Title: "+driver.getTitle());
//        System.out.println("Current Url: "+driver.getCurrentUrl());
                    Assert.assertEquals("https://rahulshettyacademy.com/loginpagePractise/", driverEdge.getCurrentUrl());
                    Assert.assertEquals("LoginPage Practise | Rahul Shetty Academy", driverEdge.getTitle());
                    Thread.sleep(3000);
                    driverEdge.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
                    driverEdge.quit();
                    break;
                case 3:
                    WebDriver driverFire = new FirefoxDriver();
                    driverFire.manage().window().maximize();
                    driverFire.get("https://rahulshettyacademy.com/client/");
//        System.out.println("Title: "+driver.getTitle());
//        System.out.println("Current Url: "+driver.getCurrentUrl());
                    Assert.assertEquals("https://rahulshettyacademy.com/client/auth/login", driverFire.getCurrentUrl());
                    Assert.assertEquals("Let's Shop", driverFire.getTitle());
                    driverFire.close();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

}
