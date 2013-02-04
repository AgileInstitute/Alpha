package com.ebay.csd.superstartrek;

public class StarBase {
	private Position pos;

	public StarBase(Position pos) {
		this.pos = pos;
	}

	public StarBase() {
		pos = new Position(0, 0);
	}

	public void setPosition(Position pos) {
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}

}
