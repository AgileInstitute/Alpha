package com.ebay.csd.superstartrek;

import java.util.Random;

public class RandomNumberGenerator {

	public int rand(int maxVal) {
		Random rand = new Random();
		int returnVal = rand.nextInt(maxVal - 0 + 1) + 0;
		return returnVal;
	}

}
