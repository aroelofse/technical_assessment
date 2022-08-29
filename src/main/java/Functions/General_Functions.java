package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_Functions extends BaseClass
{
	public void Is_Element_Visible_And_Clickable(String Element)
    {
		try
        {
            WebDriverWait Presence = new WebDriverWait(getDriver(), 20);
            Presence.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element)));
            Presence.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Element)));
        }
        catch (Exception e)
        {
        	System.out.println("Could not find element (" + Element + ") and an exception was thrown. Exception: \n" + e);
        } 
    }
	
	public void Is_Element_Clickable_And_Click(String Element)
    {
       	try
        {
       		Is_Element_Visible_And_Clickable(Element);
       		WebDriverWait Usable = new WebDriverWait(getDriver(), 20);
            Usable.until(ExpectedConditions.elementToBeClickable(By.xpath(Element)));
            WebElement elementtoclick = getDriver().findElement(By.xpath(Element));
            elementtoclick.click();
        }
        catch (Exception e)
        {
        	System.out.println("Could not find element (" + Element + ") to click and an exception was thrown. Exception: \n" + e);
        }       
    }
	
	public void Enter_Text_In_Input(String Element, String TextToEnter, boolean PressEnter)
    {
		try 
		{
			Is_Element_Visible_And_Clickable(Element);
			WebElement TypeIn = getDriver().findElement(By.xpath(Element));
			TypeIn.sendKeys(Keys.chord(Keys.CONTROL, "a"), TextToEnter);
			if(PressEnter)
			{
				TypeIn.sendKeys(Keys.RETURN);
			} 
		} 
		catch (Exception e) 
		{
			System.out.println("Could not enter text ("+ TextToEnter + ") in element (" + Element + ") . Exception: " + e);
		}
    }
	
	public void Validate_Array_Of_Objects(String[] ElementsToValidate)
    {
		try 
        {
			for (int i = 0; i < ElementsToValidate.length; i++) 
            {
				Is_Element_Visible_And_Clickable(ElementsToValidate[i]);
            }
        }
        catch (Exception e) 
        {
        	System.out.println("FAILED: Could not validate all objects exist and an exception was thrown. Exception: \n" + e);
        }
    }
	
}
