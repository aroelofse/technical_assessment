package api_test;

import org.testng.annotations.Test;
import com.mashape.unirest.http.exceptions.UnirestException;
import Functions.API_Functions;
import Functions.BaseClass;

public class Part_two extends BaseClass
{	
	API_Functions API = new API_Functions();
	String Response;
	String To = "https://swapi.dev/api/people/?search=";
	String Query = "r2-d2";
	
	@Test(priority = 0 ,description = "Send get request")
	public void do_get_request() throws UnirestException
	{	
		Response = API.Get_Request(To,Query);
		
		API.Validate_Json_Tag(Response, "skin_color", "white, blue");
	}
	
	@Test(priority = 1 ,description = "Valdidate any given tags within a JSon response")
	public void validate_get_request_tags() throws UnirestException
	{	
		API.Validate_Json_Tag(Response, "skin_color", "white, blue");
	}

}


