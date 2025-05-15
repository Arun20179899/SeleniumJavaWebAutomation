package windowhandles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SwitchTaborWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        driver.switchTo().newWindow(WindowType.TAB); // it will open new blank tab
        driver.switchTo().newWindow(WindowType.WINDOW); // it will open new window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");
//        a[href*='https://courses.rahulshettyacademy.com/p - it will get the first course from the website anytime
        String firstCourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();
        driver.switchTo().window(parentWindowId);
        // taking the WebElement Partial Screenshot
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(firstCourseName);
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("name.png"));
        driver.quit();
    }
}
