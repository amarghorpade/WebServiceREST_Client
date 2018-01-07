package com.scp.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.restassured.mapper.ObjectMapperDeserializationContext;
import com.jayway.restassured.mapper.ObjectMapperSerializationContext;
import com.jayway.restassured.mapper.factory.ObjectMapperFactory;
import com.scp.webService.RESTfulAccess.CountryBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class WebServiceImpl implements WebServiceInterface {

	public List getAllCountries() throws JSONException, JsonParseException, JsonMappingException, IOException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8090/JAXRSJsonCRUDExample/rest/countries");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);
		JSONArray array = new JSONArray(output);
		List list = new ArrayList();
		ObjectMapper oMapper = new ObjectMapper();

		for (int i = 0; i < array.length(); i++) {
			JSONObject jOb = array.getJSONObject(i);
			String str = jOb.toString();
			CountryBean cBean = oMapper.readValue(str, CountryBean.class);
			list.add(cBean);
		}
		return list;
	}

	public CountryBean getCountryById(int id) throws IOException, JSONException {
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8090/JAXRSJsonCRUDExample/rest/countries/" + id);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);
		JSONArray array = new JSONArray(output);
		ObjectMapper oMapper = new ObjectMapper();
		CountryBean cBean = null;
		for (int i = 0; i < array.length(); i++) {
			JSONObject jOb = array.getJSONObject(i);
			String str = jOb.toString();
			cBean = oMapper.readValue(str, CountryBean.class);
		}
		return cBean;
	}

	public boolean deleteCountry(int id) throws IOException {

		HttpClient httpClient = new DefaultHttpClient();
		HttpDelete delete = new HttpDelete("http://localhost:8090/JAXRSJsonCRUDExample/rest/countries/" + id);
		delete.addHeader("accept", "application/json");
		HttpResponse hResponce = httpClient.execute(delete);
		return true;
	}

	public boolean updateCountry(CountryBean cb) throws IOException, JSONException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPut post = new HttpPut("http://localhost:8090/JAXRSJsonCRUDExample/rest/countries/");

		JSONObject ob = new JSONObject();
		ob.put("id", cb.getId());
		ob.put("countryName", cb.getcountryName());
		ob.put("population", cb.getPopulation());

		StringEntity entity = new StringEntity(ob.toString());// to convert JSON to String(Universal)
		post.setEntity(entity);
		post.addHeader("Content-type", "application/json");
		httpClient.execute(post);
		return true;
		
	}

	public boolean addCountry(CountryBean cb) throws IOException, JSONException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8090/JAXRSJsonCRUDExample/rest/countries/");

		JSONObject ob = new JSONObject();
		ob.put("id", cb.getId());
		ob.put("countryName", cb.getcountryName());
		ob.put("population", cb.getPopulation());

		StringEntity entity = new StringEntity(ob.toString());// to convert JSON to String(Universal)
		post.setEntity(entity);
		post.addHeader("Content-type", "application/json");
		httpClient.execute(post);

		return true;
	}
}
