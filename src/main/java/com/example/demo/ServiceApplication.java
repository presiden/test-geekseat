package com.example.demo;

import java.util.HashMap;

public interface ServiceApplication {
	public HashMap<String, Object> calculate(HashMap<String, HashMap<String, Integer>> villagers);

	public int getBirthYear(int ageOfDeath, int yearOfDeath);

	public int getPeopleKilled(int birthYear);
}
