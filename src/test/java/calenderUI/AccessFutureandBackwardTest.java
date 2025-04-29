package calenderUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class AccessFutureandBackwardTest {
    public static void main(String[] args) {
        String monthNum;
        String dayNum;
        String yearNum;
        String decadeNum = "1991 – 2000";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Month");
        monthNum = sc.next();
        System.out.println("Enter the Date");
        dayNum = sc.next();
        System.out.println("Enter the Year");
        yearNum = sc.next();
        String[] expectedList = {monthNum, dayNum, yearNum};
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector("div[class='react-calendar__navigation'] .react-calendar__navigation__prev-button")).click();
        driver.findElement(By.xpath("//button[text()='" + decadeNum + "']")).click();
        driver.findElement(By.xpath("//button[text()='" + yearNum + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNum) - 1).click();
        driver.findElement(By.xpath("//abbr[text()='" + dayNum + "']")).click();
//        this is not get the exact text in the field as we need to refer another below HTML element to access the value
//        System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getDomAttribute("value"));
            Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);

        }

        driver.close();

    }
}
