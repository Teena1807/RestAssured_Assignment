package IBM.RestAssured_Assignment;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import Utils.utility;

import org.apache.commons.*;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.commons.io.IOUtils;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import Utils.utility;



public class RestAssuredBody {

	@Test(enabled = true,dataProvider="my data")	
	public void mydataprovider(String name1,String name2, String name3) throws JsonProcessingException
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/" ;
				
		JSONObject petobj = new JSONObject();
		JSONObject category = new JSONObject();
		JSONObject tags = new JSONObject();
	

		petobj.put("id",0);
		petobj.put("name",name1);
		petobj.put("photoUrls","");
		category.put("name", name2);
		category.put("id", 0);
		tags.put("name", name3);
		tags.put("id", 0);
		petobj.put("status", "available");
		
		// Adding the Category and Tags object into the Rootbody
		petobj.put("category", category);
		petobj.put("tags", tags);
		// JSON Array Body
		JSONArray arraybody1 = new JSONArray();
		arraybody1.add(tags);
		petobj.put("tags", arraybody1);
		JSONArray arraybody = new JSONArray();
		petobj.put("photoUrls", arraybody);
				
		ObjectMapper obj = new ObjectMapper(); // we need to use
				// com.fasterxml.jackson.databind.ObjectMapper;

String reqbody = obj.writerWithDefaultPrettyPrinter().writeValueAsString(petobj);
System.out.println(reqbody);
RestAssured.baseURI="https://petstore.swagger.io/v2/";
Response rs =given().body(reqbody)
.headers("content-type","Application/JSON"). when()
 .post("pet").then().log().all().statusCode(200).extract().response();

int statusCode = rs.getStatusCode();
Assert.assertEquals(200, statusCode);

	}
@DataProvider (name="my data")
public Object[][] getData1() throws IOException 

{
	Object[][] data = utility.gettestdata();
	
	

	return data;
}


}
