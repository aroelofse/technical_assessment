package PageObjects;

public class Shoprite_search {
	public static String Search_Bar()
    {
        return "//input[@id='js-site-search-input']";
    } 
	public static String Search_Bar_Suggestions(String Item, String Department)
    {
        return "//span[text()='"+Item+"']/../..//span[text()=' in "+Department+"']";
    } 
	public static String Item_Selection(String Item)
    {
        return "//a[contains(text(),'"+Item+"')]/../../../../..//figure";
    } 
}
