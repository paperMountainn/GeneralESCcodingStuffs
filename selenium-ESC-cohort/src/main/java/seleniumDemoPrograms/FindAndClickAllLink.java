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

public class FindAndClickAllLink {
		
	public static void main(String[] args) throws InterruptedException {		
//		System.setProperty("webdriver.gecko.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2020/Test/newnewGecko/geckodriver");
//		WebDriver driver = new FirefoxDriver();
//
//		System.setProperty("webdriver.chrome.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2018/Test/chromedriver");
		System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://sudiptac.bitbucket.io");
		//driver.get("https://istd.sutd.edu.sg/");
		//driver.get("https://www.google.com.sg");
		
		// get all the links
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
			while(staleElementLoaded) {
				try {
					//navigate to the link
					driver.navigate().to(links.get(i).getAttribute("href"));

					Thread.sleep(3000);

					//click the back button in browser
					driver.navigate().back();

					// this line is really important, if you don't have, will have exceptions

					links = driver.findElements(By.tagName("a"));

					System.out.println("*** Navigated to" + " " + links.get(i).getAttribute("href"));

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
