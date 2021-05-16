package com.example.demo;

import java.util.HashMap;

public class DemoApplication {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> villagers = new HashMap<>();
		HashMap<String, Integer> villager1 = new HashMap<>();
		HashMap<String, Integer> villager2 = new HashMap<>();

		villager1.put("ageOfDeath", 10);
		villager1.put("yearOfDeath", 12);
		villagers.put("A", villager1);

		villager2.put("ageOfDeath", 13);
		villager2.put("yearOfDeath", 17);
		villagers.put("B", villager2);

		ServiceApplicationImpl serviceApplication = new ServiceApplicationImpl();
		HashMap<String, Object> result = serviceApplication.calculate(villagers);

		System.out.println("Average people killed: " + result.get("avgPeopleKilled"));
	}

}
