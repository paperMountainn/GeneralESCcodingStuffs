package seleniumDemoPrograms;

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

public class FillMessageText {

	// hard-coded, easy to check
	static String myUserName = "escistd50.003";
	static String myPassword = "SUTD@Singapore";
	
	public static void main(String[] args) throws InterruptedException {		

		System.setProperty("webdriver.gecko.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2020/Test/newnewGecko/geckodriver");
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2018/Test/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://statcounter.com/login/");
						
		// get the user name field of the account page
		WebElement username = driver.findElement(By.id("username"));
		
		Thread.sleep(3000);
		
		// send my user name to fill up the box
		// send certain stuffs to web-element
		username.sendKeys(myUserName);
		
		Thread.sleep(3000);

		// locate the "Next" button in the account page
		WebElement password = driver.findElement(By.id("password"));	
		
		//write password
		password.sendKeys(myPassword);
		
		Thread.sleep(3000);
				
		// login and :)
		WebElement nextButton = driver.findElement(By.className("submit"));		
		nextButton.click();
		
		Thread.sleep(3000);
		
		//click project name
		// click only after successful login
		// will receive an exception if you put in wrong stuffs
		WebElement project = driver.findElement(By.id("project-name-p12207705"));		
		project.click();
	}
}

// exactly how the user will put the stuffs in the user name in the Login page, then press the login button
// can use this to automate form submission
// but but if you were to receive a captcha, it is difficult to get past this unless you use an AI
