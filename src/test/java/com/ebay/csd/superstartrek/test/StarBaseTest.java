package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Position;
import com.ebay.csd.superstartrek.StarBase;

public class StarBaseTest {

	@Test
	public void getCurrentShipPosition() {
		Position pos = new Position(3, 5);
		StarBase deepSpace9 = new StarBase();
		deepSpace9.setPosition(pos);
		Assert.assertEquals(3, deepSpace9.getPosition().getX());
		Assert.assertEquals(5, deepSpace9.getPosition().getY());
	}
}
