package com.example.demo;

import java.util.Map;

public interface ServiceApplication {
	public Map<String, Object> calculate(Map<String, Map<String, Integer>> villagers);

	public int getBirthYear(int ageOfDeath, int yearOfDeath);

	public int getPeopleKilled(int yearOfBirth);
	
	public int validateYearOfBirth(int yearOfBirth);

	public int validateAgeOfDeath(int ageOfDeath);
	
	public int validateYearOfDeath(int yearOfDeath);
	
	public boolean isValid(int validateYearOfBirth, int validateAgeOfDeath, int validateYearOfDeath);
}
