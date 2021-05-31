package IBM.RestAssured_Assignment;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Scenario2_SOAP {
	
	@Test
	public void soapscenario2() throws IOException
	{
		RestAssured.baseURI="http://www.dneonline.com/";
		FileInputStream fis = new FileInputStream(".\\Payload\\Multiply.xml");
		
		given().header("Content-Type","text/xml").body(IOUtils.toString(fis,"UTF-8"))
		.when().post("/calculator.asmx").
		then().log().all();
		
	}

}
