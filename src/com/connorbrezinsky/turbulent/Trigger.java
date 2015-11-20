package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Trigger {

	float x, y, width, height;
	int t;
	public boolean isTriggered = false;
	public static int NORMAL = 0;
	public static int AREA = 1;

	public Trigger(float _x, float _y, float w, float h, int type) {
		x = _x;
		y = _y;
		width = w;
		height = h;

		t = type;
	}

	public void showOutline(Graphics g, Color c){
		g.setColor(c);
		g.drawRect(x, y, width, height);
	}

	public void addBasicCollider(Character c){
		if(c.getX() > x && c.getX() + c.getWidth() < x + width && c.getY() > y
				&& c.getY() + c.getHeight() < y + height) {
			isTriggered = true;
		}else{

			if(getType() == 1) {
				isTriggered = false;
			}
		}
	}

	public void addCollider(Character c){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, width, height)) {
			isTriggered = true;

		}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
			isTriggered = true;

		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			isTriggered = true;

		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
				height)) {
			isTriggered = true;

		}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
			isTriggered = true;

		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width, y, width, height)) {
			isTriggered = true;

		}else if(c.x > x && c.x < x + 10 && c.y < y && c.y + c.height > y + height) {
			isTriggered = true;
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height, width, height)) {
			isTriggered = true;

		}else if(c.x < x && c.x + c.width > x && c.y < y + height - 10 && c.y + c.height > y + height - 10) {
			isTriggered = true;

		}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
				y + height - 10, width, 10)) {
			isTriggered = true;

		}else{
			if(getType() == AREA) {
				isTriggered = false;
			}
		}

	}

	public int getType(){
		return t;
	}

}
