package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;


public class TestServiceApplicationImpl {
	private ServiceApplicationImpl serviceApplicationImpl = new ServiceApplicationImpl();
	private Map<String, Map<String, Integer>> villagers = new HashMap<>();
	private Map<String, Integer> villager1 = new HashMap<>();
	private Map<String, Integer> villager2 = new HashMap<>();
	
	public TestServiceApplicationImpl() {
		villager1.put("ageOfDeath", 10);
		villager1.put("yearOfDeath", 12);
		villagers.put("A", villager1);

		villager2.put("ageOfDeath", 13);
		villager2.put("yearOfDeath", 17);
		villagers.put("B", villager2);
	}
	
	@Test
	public void testCalculateSuccess() {		
		var result = serviceApplicationImpl.calculate(villagers);
		assertEquals(4.5, result.get("avgPeopleKilled"));
	}
	
	@Test
	public void testGetBirthYearSuccess() {
		var result = serviceApplicationImpl.getBirthYear(10, 12);
		assertEquals(2, result);
	}

	@Test
	public void testGetPeopleKilledSuccess() {
		var result = serviceApplicationImpl.getPeopleKilled(5);
		assertEquals(12, result);
	}
}
