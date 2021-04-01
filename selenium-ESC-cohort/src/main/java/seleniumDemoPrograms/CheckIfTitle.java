package seleniumDemoPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class CheckIfTitle {

    public static void checkTitle(String url, WebDriver driver){
        driver.get(url);

        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        // print all the links to check
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getText());
            System.out.println(i + " " + links.get(i).getAttribute("href"));
        }

        // maximize the browser window
        driver.manage().window().maximize();

        // click all links in a web page
        for (int i = 0; i <links.size(); i++)
        {

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
                    System.out.println("the index of the link is currently " + i);
                    driver.navigate().to(links.get(i).getAttribute("href"));

                    Thread.sleep(3000);

                    // check if webpage contains title

                    if (driver.getTitle() == null || driver.getTitle().isEmpty()){
                        System.out.println("Test failed");
                        break;
                    }

                    else{
                        //click the back button in browser
                        driver.navigate().back();

                        Thread.sleep(3000);

                        // this line is really important, if you don't have, will have exceptions
                        // load all elements again
                        links = driver.findElements(By.tagName("a"));

                        // debug
                        System.out.println("*** Navigated to" + " " + links.get(i).getAttribute("href"));

                        staleElementLoaded = false;
                    }

                } catch (StaleElementReferenceException | InterruptedException e) {
                    staleElementLoaded = true;
                }
            }
        }


    }


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*driver.get("https://sudiptac.bitbucket.io");*/
//        driver.get("https://istd.sutd.edu.sg/");
//		driver.get("https://www.google.com.sg");

		checkTitle("https://www.google.com.sg", driver);

    }
}
