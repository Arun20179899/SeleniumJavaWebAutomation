package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Select staticDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        staticDropdown.selectByIndex(3);
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        staticDropdown.selectByVisibleText("AED");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        staticDropdown.selectByValue("INR");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        driver.close();
    }
}
