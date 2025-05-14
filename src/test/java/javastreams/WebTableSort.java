package javastreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSort {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        // click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        // capture all web elements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        // capture text of all web elements into new (original) list
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
        //  sort on the original list of step 3 - sorted list
        List<String> newList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sorted list
        Assert.assertTrue(originalList.equals(newList));

        // Scan the name column with getText --> print the price of the Banana
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Wheat"))
                    .map(a -> getPriceVeggie(a)).collect(Collectors.toList());
            // print the values from the list one by one using forEach
            price.forEach(s -> System.out.println(s));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);

    }

    public static String getPriceVeggie(WebElement a) {
        String price = a.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}
