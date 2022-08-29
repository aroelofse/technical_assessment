package PageObjects;

public class Shoprite_displayed_product {
	public static String Item_Selected_And_Displayed(String Item)
    {
        return "//span[@class='current-info']/../../../../../../..//h1[text()='"+Item+"']";
    } 
	public static String Item_Displayed_Price(String Rand, String Cents)
    {
        return "//span[text()=' R"+Rand+"']//sup[text()='."+Cents+"']";
    } 
	public static String Item_Displayed_Name(String Name)
    {
        return "//h1[text()='"+Name+"']";
    } 
	public static String Item_Displayed_Info(String info)
    {
        return "//div[text()='"+info+"']";
    } 
	public static String Item_Displayed_Product_Id(String ProductId)
    {
        return "//span[text()='Product ID: "+ProductId+"']";
    } 
	public static String Item_Displayed_Info_Tabs(String TabName)
    {
        return "//span[@class='current-info']/../../..//a[text()='"+TabName+"']";
    } 
	public static String Item_Displayed_Product_Description(String Description)
    {
        return "//span[@class='current-info']/../../../..//p[text()='"+Description+"']";
    } 
	public static String Item_Displayed_Product_Information(String Parameter, String Value)
    {
        return "//td[text()='"+Parameter+"']/..//td[text()='"+Value+"']";
    } 
}
