package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Position;

public class PositionTest {

	@Test
	public void getXPositionTest() {
		Position pos = new Position(1, 1);
		Assert.assertEquals(1, pos.getX());
	}

	@Test
	public void getYPositionTest() {
		Position pos = new Position(1, 1);
		Assert.assertEquals(1, pos.getY());
	}

}
