package seleniumDemoPrograms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenLinkName {
	
	public static void main(String[] args) {		
		
		// set the firefox driver
//		System.setProperty("webdriver.gecko.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2020/Test/newnewGecko/geckodriver");
//		//System.setProperty("webdriver.chrome.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2018/Test/chromedriver");
//		WebDriver driver = new FirefoxDriver();
//		//WebDriver driver = new ChromeDriver();

		// setting path for the Chrome Driver
		System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
		// instantiate driver
		WebDriver driver = new ChromeDriver();

		// open my webpage with the driver instantiated
		// .get(url) opens the url in the Chrome browser
		driver.get("https://sudiptac.bitbucket.io/");
				
		// click the link with name "ASSET research group"
		// trying to find element in the webpage obtained after clicking the ASSET research group link

		// By is used to search items in a page, find that web element with link name
		// once found, click it
		// if not, do nothing
		driver.findElement(By.linkText("ASSET Research Group")).click();


		// click the link name "Sakshi Udeshi"
		driver.findElement(By.linkText("Sakshi Udeshi")).click();
		

		// click the link name "Publications"
		driver.findElement(By.linkText("Publications")).click();

	}
}
// the code is simulating the state changes, as if a user is doing the clicking
// 