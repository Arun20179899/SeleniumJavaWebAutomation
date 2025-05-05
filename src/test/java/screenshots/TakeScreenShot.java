package screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // how to delete the cookies
        // delete all cookies
//        driver.manage().deleteAllCookies();
        // delete single cookie
//        driver.manage().deleteCookieNamed("String cookieName");

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // cast the TakeScreenShot class to Driver
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\software\\screenshot1.png"));

    }
}
