package com.example.robot.totest.model.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Gender {

	MALE, FEMALE;
	
	public static Gender getRandomGender() {
		
		List<Gender> genders = Arrays.asList(values());
		
		return genders.get(new Random().nextInt(values().length));
		
	}
	
}
