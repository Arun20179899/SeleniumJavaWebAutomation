package nextGen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        String userName = "admin";
        String password = "1234";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://192.168.0.135/Battery/default.aspx");
        Select dropdown = new Select(driver.findElement(By.id("CboFacilities")));
        dropdown.selectByValue("1");
        driver.findElement(By.id("txtUserId")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("btnOk")).click();
        Thread.sleep(2000);
//        Thread.sleep(10000);
        driver.switchTo().frame("Content");
//        Below code is to handle the img cross mark on the frame
        driver.findElement(By.cssSelector("div[class='modalPopupButtWrapper'] img")).click();
        // Below code handle YES or NO option
//        driver.switchTo().frame("ifrmPopModal");
//        driver.findElement(By.xpath("//input[@id='rblLetters_1']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@id='btnOk']")).click();
//        driver.findElement(By.cssSelector("#TabControl1_t7_")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("MainTabs");
        driver.findElement(By.xpath("//li[@id='TabControl1_t7_']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Content");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboColumnName")));
        Select serchBasedonOptions = new Select(driver.findElement(By.id("cboColumnName")));
        serchBasedonOptions.selectByValue("LeaseNo");
//        Select the Lease no through mouse over action
        Actions ac = new Actions(driver);
        WebElement mouseOverToSerchbox = driver.findElement(By.id("txtTenantName"));
//        ac.moveToElement(mouseOverToSerchbox).contextClick().sendKeys("44589").build().perform();
        driver.findElement(By.id("cmdSearch")).click();
//        driver.switchTo().alert().accept();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboColumnName")));
        WebElement mouseOverToStatusColumn = driver.findElement(By.xpath("//td[normalize-space()='Status']"));
        ac.moveToElement(mouseOverToStatusColumn).click().build().perform();
    }

}
