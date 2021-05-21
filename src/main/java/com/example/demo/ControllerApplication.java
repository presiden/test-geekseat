package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerApplication {
	@GetMapping("/index")
	public String index() {
		return "Index";
	}

	@PostMapping("/calculate")
	public String Calculate(@RequestBody Map<String, Map<String, Integer>> request) {
		ServiceApplicationImpl serviceApplication = new ServiceApplicationImpl();
		Map<String, Object> result = serviceApplication.calculate(request);

		System.out.println("Average people killed: " + result.get("avgPeopleKilled"));
		return "Average people killed: " + String.format("%.2f", result.get("avgPeopleKilled"));
	}
}
