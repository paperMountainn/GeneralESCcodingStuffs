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

// for forms, you need to fill text and submit that form

// this class autofills form and login into the page
public class FillMessageText {

	// hard-coded, easy to check
	static String myUserName = "escistd50.003";
	// if wrong, then code will throw exceptions because you cannot click on the project that did not exist
	static String myPassword = "SUTD@Singapore";
	
	public static void main(String[] args) throws InterruptedException {		

//		System.setProperty("webdriver.gecko.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2020/Test/newnewGecko/geckodriver");
//		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2018/Test/chromedriver");
		//WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://statcounter.com/login/");
						
		// get the user name field of the account page
		// web element has id "username", by using inspect in Chrome
		WebElement username = driver.findElement(By.id("username"));
		
		Thread.sleep(3000);
		
		// send my user name to fill up the box
		// send certain stuffs into the web-element
		username.sendKeys(myUserName);
		
		Thread.sleep(3000);

		// locate the "Next" button in the account page
		WebElement password = driver.findElement(By.id("password"));	
		
		//write password into the password field
		password.sendKeys(myPassword);
		
		Thread.sleep(3000);
				
		// click on login button
		// obtain reference to web-element by ways of class, id
		WebElement nextButton = driver.findElement(By.className("submit"));
		// operate on hte reference
		nextButton.click();

		// you must wait for the page to load, if not you'll end up clicking on an element that does not exist yet
		// this code
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
