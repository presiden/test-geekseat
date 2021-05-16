package com.example.demo;

import java.util.HashMap;

public class ServiceApplicationImpl implements ServiceApplication {

	@Override
	public HashMap<String, Object> calculate(HashMap<String, HashMap<String, Integer>> villagers) {

		HashMap<String, Object> result = new HashMap<>();
		int sumPeopleKilled = 0;
		double avgPeopleKilled = 0;
		int validateBirthYear = 0;

		for (HashMap.Entry<String, HashMap<String, Integer>> entry : villagers.entrySet()) {
			HashMap<String, Integer> villager = entry.getValue();
			int ageOfDeath = villager.get("ageOfDeath");
			int yearOfDeath = villager.get("yearOfDeath");
			int birthYear = getBirthYear(ageOfDeath, yearOfDeath);
			int peopleKilled = getPeopleKilled(birthYear);
			
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

	@Override
	public int getBirthYear(int ageOfDeath, int yearOfDeath) {
		int yearOfBirth = yearOfDeath - ageOfDeath;

		return yearOfBirth;
	}

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
