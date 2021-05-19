package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class DemoApplication {

	public static void main(String[] args) {
		Map<String, Map<String, Integer>> villagers = new HashMap<>();
		Map<String, Integer> villager1 = new HashMap<>();
		Map<String, Integer> villager2 = new HashMap<>();

		villager1.put("ageOfDeath", 10);
		villager1.put("yearOfDeath", 10);
		villagers.put("A", villager1);

		villager2.put("ageOfDeath", 10);
		villager2.put("yearOfDeath", 17);
		villagers.put("B", villager2);

		ServiceApplicationImpl serviceApplication = new ServiceApplicationImpl();
		Map<String, Object> result = serviceApplication.calculate(villagers);

		System.out.println("Average people killed: " + result.get("avgPeopleKilled"));
	}

}
