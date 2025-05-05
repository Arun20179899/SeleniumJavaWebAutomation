package brokenlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        SoftAssert a = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // How to get the broken links in the web page
        // Step1 - get all the url's tied up to the links using selenium
        // Step2 - there is a JAVA method will call url's and get you the status code
        // step3 - than do the validation using Soft Assertion if status code is >400 --> link which tied to the url is broken
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // get the url of the link
//        String url = driver.findElement(By.cssSelector("a[href*='appiumselenium']")).getDomAttribute("href");
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li'] //a[contains(@href,'http')]"));
        // use java method to access the status code of this link
        for (WebElement link : links) {
            // public abstract class HttpURLConnection extends URLConnection {
            String baseUrl = link.getDomAttribute("href");
            URL url = new URL(baseUrl); // or https://example.com
            URLConnection connection = url.openConnection();

            if (connection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsConn = (HttpsURLConnection) connection; // Down Casting
                // Use httpsConn here
                httpsConn.setRequestMethod("HEAD");
                httpsConn.connect();
                int respCode = httpsConn.getResponseCode();
                System.out.println(respCode);
                a.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code " + respCode + "");
                /* // hard Assertion
                if (respCode > 400) {
                    System.out.println("The link with Text " + link.getText() + " is broken with code " + respCode);
                    Assert.assertTrue(false);
                }*/

            } else if (connection instanceof HttpURLConnection) {
                HttpURLConnection httpConn = (HttpURLConnection) connection; // Down Casting
                // Use httpConn here
                httpConn.setRequestMethod("HEAD");
                httpConn.connect();
                int respCode = httpConn.getResponseCode();
                System.out.println(respCode);
                a.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code " + respCode + "");
                /* // Hard Assertion
                if (respCode > 400) {
                    System.out.println("The link with Text " + link.getText() + " is broken with code " + respCode);
                    Assert.assertTrue(false);
                }*/
            }
            /* below code is used for only unique http protocal - like if all the links are HTTPS or HTTP than below code is working
            String baseUrl = link.getDomAttribute("href");
            HttpsURLConnection conn = (HttpsURLConnection) new URL(baseUrl).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            if (respCode > 400) {
                System.out.println("The link with Text " + link.getText() + " is broken with code " + respCode);
            }*/
        }
        a.assertAll(); // this will run after validation done for all the links and give the list if any links are broken

    }
}
