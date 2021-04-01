package seleniumDemoPrograms;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Pset 3 Qn 2: This is wrong, becuase you are sending a list of usernames that you knew beforehand that is wrong
 * send N invalid usernames to Statcounter login form
 * then login with username and password
 */
public class LoginBotWithInvalidValidUser {

    public static WebDriver setWebDriver(String driverName, String path){
        // "webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe"
        System.setProperty(driverName, path);
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void sendNameAndPassword(String[] usernames, String correctPassword, WebDriver driver) throws InterruptedException {

        for (String innovativeUsername : usernames) {

            // get the user name field of the account page
            WebElement username = driver.findElement(By.id("username"));

            // send my user name to fill up the box
            username.sendKeys(innovativeUsername);

            // locate the "Next" button in the account page
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys(correctPassword);

            // login
            WebElement nextButton = driver.findElement(By.className("submit"));
            nextButton.click();

            Thread.sleep(2000);

            // Check if login failed, true if failed, false if success
            boolean isLoginFailed = driver.getPageSource().contains("Invalid Username or Password");

            // if success
            if (!isLoginFailed){
                driver.close();
            }
            else{
                // WHY CAN'T I USE THIS AGAIN?
//            username.clear();

                // clear fields for next input
                driver.findElement(By.id("username")).clear();
            }


        }


    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = setWebDriver("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");

        // go to statcounter
        driver.get("https://statcounter.com/login/");

        // correct username and password
        String myUserName = "escistd50.003";

        // correct password
        String myPassword = "SUTD@Singapore";

        // array of usernames, last one is the correct one
        String[] innovativeUsernames = {"escistd50.005", "escepd50.003", "profSud", "escistd50.003"};

        sendNameAndPassword(innovativeUsernames, myPassword, driver);
    }
}
