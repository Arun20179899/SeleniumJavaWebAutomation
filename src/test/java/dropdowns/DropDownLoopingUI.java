package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class DropDownLoopingUI {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("IMP!!!.....Maximum 9 members will be travelled");
        System.out.println("Enter how many adult to be travelling:)\nNote: 1 Adult is already selected");
        int numAdult = sc.nextInt();
        System.out.println("Enter how many Child to be travelling");
        int numChild = sc.nextInt();
        System.out.println("Enter how many infant to be travelling");
        int numInfant = sc.nextInt();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println("Before Adding Passengers: " + driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        // For Adult
        int i = 1;
        while (i <= numAdult) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        // For Child
        for (int j = 1; j <= numChild; j++) {
            driver.findElement(By.id("hrefIncChd")).click();
        }

        // For Infant

        for (int k = 1; k <= numInfant; k++) {
            driver.findElement(By.id("hrefIncInf")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println("After Adding Passengers: " + driver.findElement(By.id("divpaxinfo")).getText());
        driver.close();
    }
}
