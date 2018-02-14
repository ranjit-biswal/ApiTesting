package com.smartusys.apitest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.smartusys.Util.DataEncryptDecrypt;
import com.smartusys.Util.Info;

import static com.jayway.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;


public class LoginMobile {
	

		
		@BeforeClass
		public void setUp() {
			 baseURI="http://d.smartusys.net/";

				
		}
	 
		
//		@Test
		public void Test_GetLogin()
		{
		
			Map<String,String> jsonValue = new HashMap<>();
			jsonValue.put("EncQuery", "HocvrpZx1TuhdtlQ/NXlHd58EeVUCdAqR9n8+mAKOgWsi2mNsMx+fxN11c6OMDl2njA8Kk8r1QcuESBxI6vg+jgDGW1rLMGeqDXRlsC5J3IPAzn4ajRKdDNTXL3/uUH4nDd9P0bBrIR73OWbkp8HvMNsg/aYi5btl7UhdT9e7MkoA/lzI21p76ils7ElZFu6yx+TThDLY0LreEY7O256pUbu6DnqVNR5ojA2NugwO/Ekws+7cTA50/i5h3azhkCz1NXdGeKNW1FilPgekek7SV3j/3A6oLEzGi6jM5nE2q44GbfkpMM4i3dqFdz2bNxyEZaVyqPPk+N+4793XFWZVElKcZaVPdPdtpon9UHVaUs=");
			jsonValue.put("encType", "I");
	     

		Response res =	given().
					contentType("application/json").
					body(jsonValue).
					when().
					post("/scp6.6.3-service/UserLogin.svc/ValidateUserLoginMob");
			System.out.println(" Response code is " + res.asString());
			System.out.println(" Response code is " + res.getHeaders());
			System.out.println(" Response code is " + res.statusCode());
			Assert.assertEquals( res.statusCode(), 200);
					

			
		}
		
		@Test
		public void Test_GetKeyGenerate() throws Exception 
		{
			DataEncryptDecrypt dataEncryptDecrypt = new DataEncryptDecrypt();
			System.out.println(dataEncryptDecrypt.Decrypt("abcd", "PasswordPassword"));
		}



}