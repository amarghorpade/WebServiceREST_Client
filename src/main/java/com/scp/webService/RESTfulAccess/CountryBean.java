package com.scp.webService.RESTfulAccess;

public class CountryBean 
{
	private int id;
	private String countryName;
	private int population;
	
	
	
	public CountryBean(int id, String countryName, int population) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.population = population;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcountryName() {
		return countryName;
	}
	public void setcountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "\n [id=" + id + ", countryName=" + countryName + ", population=" + population + "]";
	}
	public CountryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
