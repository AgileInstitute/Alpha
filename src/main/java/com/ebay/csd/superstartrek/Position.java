package com.ebay.csd.superstartrek;

public class Position {
	private int x,y;
	
	public Position(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX(){
		return x;
	}
	
	
}
