package javastreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableFilter {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        // 1 Result
        List<WebElement> filterList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
        // 1 Result
        Assert.assertEquals(veggies.size(),filterList.size());

    }
}
