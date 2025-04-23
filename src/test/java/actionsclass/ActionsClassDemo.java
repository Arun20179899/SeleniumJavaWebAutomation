package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Actions a = new Actions(driver);
        WebElement mouseHover = driver.findElement(By.xpath("//a[@class='cart-header-navlink'][1]"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[class='search-keyword']"));
//      Below is Regular actions
        a.moveToElement(mouseHover).contextClick().build().perform();
//      Below is composite actions - multiple actions are happened
        a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("tomato").doubleClick().build().perform();

//        contextClick() - Right click on the mouse
//        click - Left-click on the mouse
//        keyDown(Keys.SHIFT) - select the shift keyword on the keyboard
//        moveToElement(WebElement target) - mouse hover the specific element
//


    }
}
