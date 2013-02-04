package com.ebay.csd.test.superstartrek;

import com.ebay.csd.superstartrek.RandomNumberGenerator;

public class RandomMock extends RandomNumberGenerator {
	
	private int nextHit = 0;

	public int rand(int maxVal) {
		return nextHit;
	}

	public void nextHit(int i) {
		this.nextHit = i;
	}
}
