package Functions;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Browser_Functions extends BaseClass
{	
	@Test
	public void Navigate_To_URL(String URL)
	{
		getDriver().get(URL);
    }
	
	public void Scroll_Element_Into_View(String Element)
    {
		try{
			WebElement elementtomoveTo = getDriver().findElement(By.xpath(Element));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", elementtomoveTo);
        }
        catch (Exception e) 
        {
        	System.out.println("FAILED: Could not validate all objects exist and an exception was thrown. Exception: \n" + e);
        }
    }
	
	@Test
	public void Quit_Driver()
	{
		System.out.println("Note: Closing Chrome browser"); 
		getDriver().quit();
		System.out.println("Note: Browser Closed"); 
    }
}
