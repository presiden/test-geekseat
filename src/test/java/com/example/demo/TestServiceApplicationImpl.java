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

	@Test
	public void testValidateYearOfBirth() {
		int yearOfBirth = 0;
		var result = serviceApplicationImpl.validateYearOfBirth(yearOfBirth);
		assertEquals(-1, result);
	}

	@Test
	public void testValidateAgeOfDeath() {
		int ageOfBirth = -1;
		var result = serviceApplicationImpl.validateAgeOfDeath(ageOfBirth);
		assertEquals(-1, result);
	}

	@Test
	public void testValidateYearOfDeath() {
		int yearOfDeath = 0;
		var result = serviceApplicationImpl.validateYearOfDeath(yearOfDeath);
		assertEquals(-1, result);
	}

	@Test
	public void testIsValid() {
		int validateYearOfBirth = 0, validateAgeOfDeath = 0, validateYearOfDeath = 0;
		var result = serviceApplicationImpl.isValid(validateYearOfBirth, validateAgeOfDeath, validateYearOfDeath);
		assertEquals(true, result);
	}
}
