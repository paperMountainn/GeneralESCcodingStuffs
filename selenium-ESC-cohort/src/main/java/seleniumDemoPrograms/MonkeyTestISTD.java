package seleniumDemoPrograms;
import net.bytebuddy.asm.Advice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Pset 3 Qn 1
 * Randomly click links on ISTD webpage
 */
public class MonkeyTestISTD {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

		driver.get("https://istd.sutd.edu.sg/");

        // get all the links by the tag name <a
        // a = anchor elements, so we store all the anchor elements in a list
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        // print all the links
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getText());
            System.out.println(i + " " + links.get(i).getAttribute("href"));
        }

        // maximize the browser window
        driver.manage().window().maximize();

        // click all links in a web page
        for(int i = 0; i < links.size(); i++)
        {
            System.out.println("*** Navigating to" + " " + links.get(i).getAttribute("href"));
            //if (links.get(i).getAttribute("href") == null ||
            //		links.get(i).getAttribute("href").equals("https://sudiptac.bitbucket.io"))
            if (links.get(i).getAttribute("href") == null)
                continue;

            boolean staleElementLoaded = true;

            //the loop checks whether the elements is properly loaded
            // staleElement : elements with no proper values. if page is not loaded, or loaded with stale, will throw exceptions, catch them
            // and then reload the page again
            // if something went wrong, do the catch block
            // repeat while loop until the webpage is properly loaded

            // statelElementLoaded: sometimes page does not load properly, throws this
            // catching this exception, make it true first, if its false it means that it loaded proper.y
            while(staleElementLoaded) {
                try {
                    //navigate to the link
                    driver.navigate().to(links.get(i).getAttribute("href"));
                    System.out.println("Navigated to link at index " + i);

                    Thread.sleep(3000);

                    //click the back button in browser
                    driver.navigate().back();
                    System.out.println("Hello you are back from index " + i);


                    // this line is really important, if you don't have, will have exceptions
                    // load all elements again
                    links = driver.findElements(By.tagName("a"));

                    // debug
//                    System.out.println("*** Navigated to" + " " + links.get(i).getAttribute("href"));

                    staleElementLoaded = false;
                } catch (StaleElementReferenceException e) {
                    staleElementLoaded = true;
                }
            }
        }
    }
}

// if intention: just to check links work properly -> you do not have to open up, just link up with the web
// use BrokenLinkFinder file
