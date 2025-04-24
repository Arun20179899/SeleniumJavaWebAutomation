package realtimescenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class HandleLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // 1. give me the links count in the page
        //a
        int linksPage = driver.findElements(By.tagName("a")).size();
        System.out.println("Count of links in main Page: " + linksPage);

        // 2. give me the links count in footer page
//        login is to first switch the driver instance to footer than driver once
//        get knowledge footer page than access the links in the footer
        WebElement footerdriver = driver.findElement(By.id("gf-BIG")); // limited the scope to footer
        // access the links through footerdriver instance
        int linksFooter = footerdriver.findElements(By.tagName("a")).size();
        System.out.println("Count of links in footer Page: " + linksFooter);

        // here we will access only first column links and get the text of those links
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int linksFirstColumn = columndriver.findElements(By.tagName("a")).size();
        System.out.println(linksFirstColumn);

        for (WebElement link : columndriver.findElements(By.tagName("a"))) {
            System.out.println(link.getText());
        }

        //4- click on each link in the coloumn and check if the pages are opening-
        for (int i = 1; i < linksFirstColumn; i++) {
            String clickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
            Thread.sleep(3000);
        } // opens all the tabs

        Set<String> tabList = driver.getWindowHandles(); // 4 windows are opened
        Iterator<String> it = tabList.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            Thread.sleep(2000);
            System.out.println(driver.getTitle());
        }
        driver.quit();

    }
}
