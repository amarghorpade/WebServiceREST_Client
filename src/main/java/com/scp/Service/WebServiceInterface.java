package com.scp.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.scp.webService.RESTfulAccess.CountryBean;

public interface WebServiceInterface
{
	public CountryBean getCountryById(int id) throws JsonParseException, JsonMappingException, IOException, JSONException;//GET with ID
	public List getAllCountries() throws JSONException, JsonParseException, JsonMappingException, IOException;//GET
	public boolean deleteCountry(int id) throws IOException;//DELETE
	public boolean updateCountry(CountryBean cb) throws IOException, JSONException;//PUT
	public boolean addCountry(CountryBean cb) throws  IOException, JSONException;//PUT
}
