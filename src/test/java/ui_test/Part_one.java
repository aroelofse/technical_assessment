package ui_test;
		
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Functions.BaseClass;
import Functions.Browser_Functions;
import Functions.General_Functions;
import PageObjects.Shoprite_search;
import PageObjects.Shoprite_displayed_product;

public class Part_one extends BaseClass
{	
	Browser_Functions Browser = new Browser_Functions();
	General_Functions General = new General_Functions();
	String URL = "https://www.shoprite.co.za/";
	String Drink = "Ceres 100% Mango Juice 200ml";
	String Department = "Juices & Smoothies";
	String PriceRand = "9";
	String PriceCent = "99";
	String DisplayedInformation = "Exotic mango crushed with apple and pear juice to make a smooth but vibrant juice, packed with flavour. Rich in colour, with a tropical aroma. This 100% juice blend is a tasty way to top up your vitamin C.";
	String ProductId = "000000000010147924";
	String ProductDescription = "From the Ceres Valley, straight to your table. Every drop produced with care in the sunny valley we call home. Our wide range of juices is carefully crafted to quench your thirst and drench your taste buds with deliciousness.";
	String[] ProductInformation = new String[] {Shoprite_displayed_product.Item_Displayed_Product_Information("Product Brand","Ceres"),
												Shoprite_displayed_product.Item_Displayed_Product_Information("Product Volume","200ml"),
												Shoprite_displayed_product.Item_Displayed_Product_Information("Unit of Measure","EA"),
												Shoprite_displayed_product.Item_Displayed_Product_Information("Main Barcode","6001240200254")};
	
	@BeforeTest
	public void beforeTest()
	{
		Start_Driver();
	}

	@Test(priority = 0 ,description = "Navigate to URL supplied")
	public void Navigate_To_URL()
	{	
		Browser.Navigate_To_URL(URL);
	}
	
	@Test(priority = 1,description = "Use Search field to search for a product and select it from the hint drop down")
	public void Search_Functionality()
	{	
		General.Enter_Text_In_Input(Shoprite_search.Search_Bar(), Drink, false);
		
		General.Is_Element_Clickable_And_Click(Shoprite_search.Search_Bar_Suggestions(Drink, Department));
		
		General.Is_Element_Visible_And_Clickable(Shoprite_search.Item_Selection(Drink));
	}
	
	@Test(priority = 2,description = "Select the search product from the results supplied in the search")
	public void Select_Product()
	{	
		General.Is_Element_Clickable_And_Click(Shoprite_search.Item_Selection(Drink));
		
		General.Is_Element_Visible_And_Clickable(Shoprite_displayed_product.Item_Selected_And_Displayed(Drink));
	}
	
	@Test(priority = 3,description = "Validate Product Price, Name, Displayed Info and Product Id is correct")
	public void Validate_Displayed_Product()
	{	
		General.Is_Element_Visible_And_Clickable(Shoprite_displayed_product.Item_Displayed_Price(PriceRand,PriceCent));
		
		General.Is_Element_Visible_And_Clickable(Shoprite_displayed_product.Item_Displayed_Name(Drink));
		
		General.Is_Element_Visible_And_Clickable(Shoprite_displayed_product.Item_Displayed_Info(DisplayedInformation));
		
		General.Is_Element_Visible_And_Clickable(Shoprite_displayed_product.Item_Displayed_Product_Id(ProductId));
	}
	
	@Test(priority = 4,description = "Scroll down and validate the Tabs containing Product Information or Product Description is correct")
	public void Validate_Product_Information()
	{	
		Browser.Scroll_Element_Into_View(Shoprite_displayed_product.Item_Displayed_Info_Tabs("Product Information"));
		
		General.Is_Element_Clickable_And_Click(Shoprite_displayed_product.Item_Displayed_Info_Tabs("Product Information"));
		
		General.Validate_Array_Of_Objects(ProductInformation);
		
		General.Is_Element_Clickable_And_Click(Shoprite_displayed_product.Item_Displayed_Info_Tabs("Description"));
		
		General.Is_Element_Visible_And_Clickable(Shoprite_displayed_product.Item_Displayed_Product_Description(ProductDescription));
	}
	
	@AfterTest
	public void afterTest()
	{
		
		Browser.Quit_Driver();
	}
}


