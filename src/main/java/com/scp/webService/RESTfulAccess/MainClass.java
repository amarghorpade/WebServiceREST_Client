package com.scp.webService.RESTfulAccess;

import java.io.IOException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.scp.Service.WebServiceImpl;
import com.scp.Service.WebServiceInterface;

public class MainClass {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, JSONException, IOException
	{
		WebServiceInterface ws= new WebServiceImpl();
		//ws.getAllCountries();//GET
		//System.out.println("*****************************");
		//ws.getCountryById(3);//GET by id
		//System.out.println(ws.deleteCountry(1));
		CountryBean cb1= new CountryBean(1,"England",10);
		//ws.addCountry(cb1);
		//ws.getAllCountries();//GET
		ws.updateCountry(cb1);
		
	}
}
