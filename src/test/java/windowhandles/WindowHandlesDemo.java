package windowhandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlesDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> window = driver.getWindowHandles();
//        pull the windows id
        Iterator<String> it = window.iterator(); // [parentID, childID]
//        Access ids
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
//        Please email us at mentor@rahulshettyacademy.com with below template to receive response
        String email = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(email);
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
        driver.quit(); // it will close both parent and child window


    }

}
