package Functions;

import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass
{
	public String currentUsersHomeDir = System.getProperty("user.dir");
	private static WebDriver driver;
	
	public void Start_Driver(){
		System.setProperty("webdriver.chrome.driver", currentUsersHomeDir + "\\chromedriver.exe");
		System.out.println("Note: Launching Chrome browser from: " + currentUsersHomeDir + "\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("enable-automation");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");
		options.addArguments("window-size=1920x1080");
		setDriver(new ChromeDriver(options));
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Note: Chrome Browser Launched"); 
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BaseClass.driver = driver;
	}
}
