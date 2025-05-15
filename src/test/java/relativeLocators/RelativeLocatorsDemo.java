package relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsDemo {
    public static void main(String[] args) {
        // Relative Locators - above(), below(), toLeftof() and toRightOf()
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // above() - get the name text of above the NameEditBox
        WebElement editNameBox = driver.findElement(By.cssSelector("input[name='name']"));
        String aboveLabel = driver.findElement(with(By.tagName("label")).above(editNameBox)).getText();
        System.out.println(aboveLabel);

        // below()

        WebElement submitButton = driver.findElement(By.cssSelector(".btn"));
        driver.findElement(with(By.tagName("input")).below(submitButton)).sendKeys("Arun Gowda A S");

        //toLeftOf()
        WebElement checkBoxLeft = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxLeft)).click();

        //toRightOf
        WebElement rbt = driver.findElement(By.id("inlineRadio1"));
        driver.findElement(with(By.tagName("label")).toRightOf(rbt)).click();

    }
}
