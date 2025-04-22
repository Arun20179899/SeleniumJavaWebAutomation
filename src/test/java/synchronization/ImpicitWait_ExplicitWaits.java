package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImpicitWait_ExplicitWaits {
    public static void main(String[] args) throws InterruptedException {
        String promoCode = "rahulshettyacademy";
        WebDriver driver = new ChromeDriver();
//        Implicit Waits
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Explicit Waits
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String[] itemsNeeded = {"Beans", "Brocolli", "Cucumber", "Beetroot", "Carrot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode"))); // Waits defined Explicitly
        driver.findElement(By.cssSelector(".promoCode")).sendKeys(promoCode);
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo"))); // Waits defined Explicitly
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
        driver.close();


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException {
        int j = 0;
        //        //button[text()='ADD TO CART']
//        grab all the products and store it variable
        List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
        for (int i = 0; i < products.size(); i++) {
//            Brocolli - 1 Kg
            String[] name = products.get(i).getText().split("-");
//            0 - Brocolli
//            1 -  1 Kg
            String formatedName = name[0].trim();
            // formated into get actual vegetable name
            // convert array into arraylist for easy search
            // check whether name you extracted is present in ArrayList or not
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
//            System.out.println(itemsNeededList);
//            Assert.assertTrue(itemsNeededList.contains(name));

            if (itemsNeededList.contains(formatedName)) {
                Thread.sleep(3000);
                j++;
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//                Do not relay on text while locating the element as it will dynamic in nature and keep on changing during the execution
//                in these case - once clicked on "ADD TO CART" button it has been chnaged to "ADDED" button
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) break;
            }

        }
    }
}
