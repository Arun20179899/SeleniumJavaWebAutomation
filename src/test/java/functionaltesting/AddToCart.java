package functionaltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String[] itemsNeeded = {"Cucumber", "Brocolli"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//        //button[text()='ADD TO CART']
//        grab all the products and store it variable
        List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            // convert array into arraylist for easy search
            // check whether name you extracted is present in ArrayList or not
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(name)) {
                Thread.sleep(3000);
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
            }

        }
//        driver.findElement(By.cssSelector(".cart-icon")).click();
    }
}
