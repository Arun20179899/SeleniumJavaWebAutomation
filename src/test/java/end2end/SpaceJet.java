package end2end;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Scanner;

public class SpaceJet {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
        // Access Auto Suggestive Dropdown
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
            }
        }
        // Dynamic Dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // We can handle this through index
        // If Lead do not accept indexes than we can handle this through Parent to Child concept
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(2000);
        // Calender

        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        // check the reverse calendar option enabled or not

        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
            System.out.println("it is disabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("it is enabled");
            Assert.assertFalse(false);
        }
        Thread.sleep(2000);
        // Dropdown Looping UI

        Scanner sc = new Scanner(System.in);
        System.out.println("IMP!!!.....Maximum 9 members will be travelled");
        System.out.println("Enter how many adult to be travelling:)\nNote: 1 Adult is already selected");
        int numAdult = sc.nextInt();
        System.out.println("Enter how many Child to be travelling");
        int numChild = sc.nextInt();
        System.out.println("Enter how many infant to be travelling");
        int numInfant = sc.nextInt();
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

        Thread.sleep(2000);

        // Static Dropdown
        Select staticDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        staticDropdown.selectByIndex(3);
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        staticDropdown.selectByVisibleText("AED");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        staticDropdown.selectByValue("INR");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());

        Thread.sleep(2000);
        // Checkbox

        Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
        driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
//        System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());

//        count of checkbox
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

        Thread.sleep(2000);
        // click on Search button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }


}

