package seleniumDemoPrograms;

import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

public class BrokenLinkFinder {


	/**
	 * Try to establish HTTP connection with the url object (link)
	 * @param hyperLink
	 * @throws Exception
	 */
	
	// this is a function which checks whether a given hyper link in a web page is broken
	public static void brokenLinkChecker(URL hyperLink) throws Exception {
		String acknowledge = null;
		int code = 0;

		// create HTTP connection
		HttpURLConnection linkConnection = (HttpURLConnection) (hyperLink.openConnection());
		//linkConnection.setRequestMethod("GET");
		try {	
			System.out.println("*** Checking link " + hyperLink.toString());
			// initiate an HTTP connection
		    linkConnection.connect();

		    // check whether the connection is responding
			// use this code as oracle
		    acknowledge = linkConnection.getResponseMessage();
		    code = linkConnection.getResponseCode();

		    // disconnect the connection links
		    linkConnection.disconnect();

			// print!
		    System.out.println("*** The link " + "returned " + code);
		}
		// in case link requires a certification...
		catch(Exception e) {
			System.out.println("*** Throws exception " + e.toString());
		    System.out.println("*** The link " + "is not HTTP or requires certificate validation, message = " + acknowledge);
		}  				
	}
		
	public static void main(String[] args) throws Exception {		
//		System.setProperty("webdriver.gecko.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2019/Test/newGecko/geckodriver");
//		WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver","D:/Downloads D Drive/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//System.setProperty("webdriver.chrome.driver","/Users/sudiptac/sudiptac/teaching/SUTD/50.003@2018/Test/chromedriver");
		//WebDriver driver = new ChromeDriver();

		//driver.get("https://sudiptac.bitbucket.io");
		//driver.get("https://istd.sutd.edu.sg/");
		//driver.get("https://www.google.com.sg");
		driver.get("https://statcounter.com/");
		//driver.get("http://2019.rtss.org/");
		//driver.get("https://www.netsparker.com/blog/web-security/cve-2014-6271-shellshock-bash-vulnerability-scan/");
			
		// get all the links
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
				
		// print all the links
		for (int i = 0; i < links.size(); i=i+1) {
			System.out.println(i + " " + links.get(i).getText());
			System.out.println(i + " " + links.get(i).getAttribute("href"));
		}
		
		// call broken link checker for all the links found
		// instead of running through all the links, prof wants to show the url that error occurs
		for (int i = 50; i < links.size(); i=i+1) {
		try {
				//System.out.println("*** Checking link " + i);
				brokenLinkChecker(new URL(links.get(i).getAttribute("href")));
		} catch (Exception e) {
				System.out.println("This is not a proper HTTP URL or requires certificate validation " + links.get(i).getAttribute("href"));
		}
	  }
	}
}

// this code is must faster, not loading the webpage at all, showing the browser is not important
// instead, show the log! It is basically establishing connections and printing the connection code
// if the log shows 404, means that something is wrong!!!! Connection not established, you can try yourself by clicking the link