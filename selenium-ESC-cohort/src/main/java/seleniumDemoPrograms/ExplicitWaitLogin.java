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

public class ExplicitWaitLogin {
	
	static String myUserName = "@@escistd50.003";
	static String myPassword = "SUTD@Singapore";
	
	public static void main(String[] args) throws InterruptedException {		

//		System.setProperty("webdriver.gecko.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2019/Test/newGecko/geckodriver");
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://statcounter.com/login/");
						
		// get the user name field of the account page
		WebElement username = driver.findElement(By.id("username"));
		
		// send my user name to fill up the box
		username.sendKeys(myUserName);

		// locate the "Next" button in the account page
		WebElement password = driver.findElement(By.id("password"));		
		password.sendKeys(myPassword);
		
		// login and :)
		WebElement nextButton = driver.findElement(By.className("submit"));		
		nextButton.click();
		
		//explicitly wait until the password field is present in the page
		// a better way as compared to FillMessageText

		try {
			// wait for max 10 seconds for some conditions, and after that if condition not true, throw an exception
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// wait only until expected condition :  project front page loads,
			// you want the element to become clickable, this is blocking call
			// wait until the expectation is satisfied
			// if not, after 10s, throw exception then you catch the exception
			// a better way as compared to thread.sleep() in FillMessageText

			// wait until the element with id becomes clickable. Unless the page is loaded, the element will not be
			// clickable
			wait.until(ExpectedConditions.elementToBeClickable(By.id("project-name-p12207705")));
			// click project link 
			driver.findElement(By.id("project-name-p12207705")).click();
			// catch here
			// if the link is not clickable within 10 s, throw exception
		} catch (Exception NoSuchElementException) {
				System.out.println("login/password name invalid");
		}
	}
}
