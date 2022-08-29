package Functions;

import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class API_Functions extends BaseClass
{   
	public String Get_Request(String URL,String Query) throws UnirestException 
	{  
		String prettyJsonString ="";
		String To = URL + Query;
		try {
			HttpResponse <JsonNode> response = Unirest.get(To)
					.asJson();
			System.out.println(response.getStatusText());
			System.out.println(response.getStatus());
			if(response.getStatus() != 200){
				System.out.println("Failed to validate that the response code was 200. Recieved code: "+ response.getStatus());}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonElement je = JsonParser.parseString(response.getBody().toString());
			prettyJsonString = gson.toJson(je);
			System.out.println(prettyJsonString);
		} catch (Exception e) {
			System.out.println("Failed to send request and receive response from URL: " + URL + Query+ ". Exception: \n"+ e);
		}
		return prettyJsonString;
	}
	
	public boolean Validate_Json_Tag(String JSonToCompare,String Tag, String ExpectedTagValue) throws UnirestException 
	{  
		try {
			JSONObject root = new JSONObject(JSonToCompare);
			JSONArray resultsArray = root.getJSONArray("results");
			JSONObject objResults = resultsArray.getJSONObject(0);
			String TagValue = objResults.getString(Tag);
			if(!TagValue.contains(ExpectedTagValue)){
				System.out.println("Skin Color: " + TagValue + " does not match expected result: " + ExpectedTagValue);
				return false;
			}
		} catch (Exception e) {
			System.out.println("Failed to get the Tag value from tag : " + Tag + ". Exception: \n"+ e);
		}
		return true;
	}
}
