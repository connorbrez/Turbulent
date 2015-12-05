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

	public boolean addCollider(Character c){
		if(Main.leftBoxCollider(c, this)) {
			isTriggered = true;
			return true;
		}else if(Main.topBoxCollider(c, this)) {
			isTriggered = true;
			return true;

		}else if(Main.rightBoxCollider(c, this)) {
			isTriggered = true;
			return true;

		}else if(Main.bottomBoxCollider(c, this)) {
			isTriggered = true;
			return true;

		}else{
			if(t == AREA) {
				isTriggered = false;
				return false;

			}
			return false;
		}

	}

	public void setTriggerRadius(float _x, float _y, float w, float h){
		x=_x;
		y=_y;
		width=w;
		height=h;
	}
	
	public int getType(){
		return t;
	}

}
