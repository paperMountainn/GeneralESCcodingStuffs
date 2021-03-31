package seleniumDemoPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

/**
 *  Pset 3 Qn 3
 *  Check whether all web pages directly reachable from a given webpage have titles.
 *  test fail if any has empty title
 */
public class HeaderNameFinder {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.sg");

        // get all the links
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println("***Printing all link names***");
        // print all the links
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getText());
        }
        System.out.println("***Printing all link addresses***");
        // print all the hyper links
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getAttribute("href"));
        }

        for (int i = 0; i < links.size(); i=i+1) {
            WebElement title = driver.findElement(By.tagName("title"));



        }

    }

}
