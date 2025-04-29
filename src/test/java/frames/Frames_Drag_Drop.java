package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames_Drag_Drop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
//      below code will enter to the frame
//        iframe was handled by using Web element
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
//        iframe was handled by using iframe index
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
//        drag and drop the element
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source,target).build().perform();
//        after once done the work in the frame than come out of that frame
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Accept']")).click();
    }
}
