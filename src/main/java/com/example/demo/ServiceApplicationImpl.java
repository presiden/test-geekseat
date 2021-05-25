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
		int validateYearOfBirth = 0;
		int validateAgeOfDeath = 0;
		int validateYearOfDeath = 0;
		boolean isValid = false;

		for (Map.Entry<String, Map<String, Integer>> entry : villagers.entrySet()) {
			Map<String, Integer> villager = entry.getValue();
			int ageOfDeath = villager.get("ageOfDeath");
			int yearOfDeath = villager.get("yearOfDeath");
			int yearOfBirth = getBirthYear(ageOfDeath, yearOfDeath);
			int peopleKilled = getPeopleKilled(yearOfBirth);
			
			//Validate year of birth
			if(validateYearOfBirth == 0)
				validateYearOfBirth = validateYearOfBirth(yearOfBirth);
			
			//Validate age of death
			if(validateAgeOfDeath == 0)
				validateAgeOfDeath = validateAgeOfDeath(ageOfDeath);
			
			//Validate year of death
			if(validateYearOfDeath == 0)
				validateYearOfDeath = validateYearOfDeath(yearOfDeath);
			
			villager.put("yearOfBirth", yearOfBirth);
			villager.put("peopleKilled", peopleKilled);

			sumPeopleKilled += peopleKilled;
			result.put(entry.getKey(), villager);
		}

		//Check data valid or invalid
		isValid = isValid(validateYearOfBirth, validateAgeOfDeath, validateYearOfDeath);
		
		//If year of birth is valid and age is valid, then calculate average 
		avgPeopleKilled = isValid ? (double) sumPeopleKilled / villagers.size() : -1;

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
	
	/**
	 * time complexity : O(1)
	 * space complexity : O(1)
	 */
	//If year of birth is less than 1, then return -1
	@Override
	public int validateYearOfBirth(int yearOfBirth) {
		int validateYearOfBirth = yearOfBirth < 1 ? -1 : 0;

		return validateYearOfBirth;
	}

	/**
	 * time complexity : O(1)
	 * space complexity : O(1)
	 */
	//If age is negative, then return -1
	@Override
	public int validateAgeOfDeath(int ageOfDeath) {
		int validateAgeOfDeath = ageOfDeath < 0 ? -1 : 0;
		
		return validateAgeOfDeath;
	}
	
	/**
	 * time complexity : O(1)
	 * space complexity : O(1)
	 */
	//If year of death is less than 1, then return -1
	@Override
	public int validateYearOfDeath(int yearOfDeath) {
		int validateYearOfDeath = yearOfDeath < 1 ? -1 : 0;
		
		return validateYearOfDeath;
	}
	
	/**
	 * time complexity : O(1)
	 * space complexity : O(1)
	 */
	//If all validation is true, then return true, otherwise return false
	@Override
	public boolean isValid(int validateYearOfBirth, int validateAgeOfDeath, int validateYearOfDeath) {
		boolean isValid = validateYearOfBirth == 0 && validateAgeOfDeath == 0 && validateYearOfDeath == 0;
		
		return isValid;
	}
}
