package com.smartusys.apitest;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
	public static void main(String[] args) throws Exception 
    {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("E:\\workspace\\ApiTesting\\src\\test\\java\\data\\data.json"));
         
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
         
        // getting firstName and lastName
        String firstName = (String) jo.get("firstName");
		System.out.println(firstName);
	}

}
