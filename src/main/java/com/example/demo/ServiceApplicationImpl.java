package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class ServiceApplicationImpl implements ServiceApplication {

	/**
	 * time complexity : O(n)
	 * space complexity : O(n)
	 */
	@Override
	public Map<String, Object> calculate(Map<String, Map<String, Integer>> villagers) {
		Map<String, Object> result = new HashMap<>();
		int sumPeopleKilled = 0;
		double avgPeopleKilled = 0;
		int validateBirthYear = 0;

		for (Map.Entry<String, Map<String, Integer>> entry : villagers.entrySet()) {
			Map<String, Integer> villager = entry.getValue();
			int ageOfDeath = villager.get("ageOfDeath");
			int yearOfDeath = villager.get("yearOfDeath");
			int birthYear = getBirthYear(ageOfDeath, yearOfDeath);
			int peopleKilled = getPeopleKilled(birthYear);
			
			//Validate birthyear
			if(validateBirthYear == 0)
				validateBirthYear = birthYear < 1 ? -1 : 0;
			
			villager.put("birthYear", birthYear);
			villager.put("peopleKilled", peopleKilled);

			sumPeopleKilled += peopleKilled;
			result.put(entry.getKey(), villager);
		}

		avgPeopleKilled = validateBirthYear == 0 ? (double) sumPeopleKilled / villagers.size() : -1;

		result.put("sumPeopleKilled", sumPeopleKilled);
		result.put("avgPeopleKilled", avgPeopleKilled);

		return result;
	}

	/**
	 * time complexity : O(1)
	 * space complexity : O(1)
	 */
	@Override
	public int getBirthYear(int ageOfDeath, int yearOfDeath) {
		int yearOfBirth = yearOfDeath - ageOfDeath;

		return yearOfBirth;
	}

	/**
	 * time complexity : O(n)
	 * space complexity : O(1)
	 */
	@Override
	public int getPeopleKilled(int birthYear) {
		int summary = 1, year = 1;
		int n1 = 0, n2 = 1, n3 = 1;

		if (birthYear < 1)
			return 0;
		else if (birthYear == 1)
			return summary;

		while (true) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			summary += n3;

			year++;
			if (year == birthYear)
				break;
		}

		return summary;
	}
}
