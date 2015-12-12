package com.connorbrezinsky.turbulent.object;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.PhysicsObject;
import com.connorbrezinsky.turbulent.Trigger;

public class Switch extends Object {

	public Switch(float _x, float _y, float w, float h, Color c) {
		super(_x, _y, w, h, c);
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}

	public Switch(float _x, float _y, float w, float h, Image[] i, int[] d) {
		super(_x, _y, w, h, i, d);
		x = _x;
		y = _y;
		width = w;
		height = h;
	}

	public Switch(float _x, float _y, float w, float h) {
		super(_x, _y, w, h);
		x = _x;
		y = _y;
		width = w;
		height = h;
	}

	public int type;
	public Color color;

	public boolean triggered = false;

	float tX, tY, tW, tH;
	boolean cTrigRadius = false;

	public static int PRESSURE = 0;
	public static int ACTION = 1;

	public void setCustomActionRadius(float _x, float _y, float w, float h){
		tX = _x;
		tY = _y;
		tW = w;
		tH = h;
		cTrigRadius = true;
	}

	public void showTrigRadius(Graphics g, Color c){
		g.setColor(c);
		if(cTrigRadius) {
			g.drawRect(getX() - tX, getY() - tY, width + tW, height + tH);
		}else{
			g.drawRect(x - 30, y - 30, width + 60, height + 60);

		}
	}

	public void addListener(Character c, int t, Input i){
		type = t;
		Trigger trig = new Trigger(this.getX() - 25, this.getY() - 25, this.getWidth() + 60, this.getHeight() + 60,
				Trigger.AREA);
		if(cTrigRadius) {
			trig.setTriggerRadius(getX() - tX, getY() - tY, width + tW, height + tH);
		}

		trig.addBasicCollider(c);

		if(trig.isTriggered && type == ACTION) {
			if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
				System.out.println("pressed");

				if(triggered) {
					triggered = false;
				}else{
					triggered = true;
				}
			}
		}else if(type == PRESSURE) {

			if(Main.topBoxCollider(c, this)) {
				triggered = true;
			}else{
				triggered = false;
			}
		}

	}

	public void addListener(PhysicsObject c, int t, Input i){
		type = t;
		if(Main.addCollisonBox(c.getX() + c.getWidth() + 1, c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y, 10,
				height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}

		}else if(Main.addCollisonBox(c.getX() + c.getWidth() + 1, c.getY() + c.getHeight() + 1, c.getWidth() + 1,
				c.getHeight() + 1, x, y, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;

			}
		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight() + 1, c.getWidth() + 1, c.getHeight() + 1, x, y,
				width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;

			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 9, y, 10, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;

			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y + height - 9, width,
				10)) {
			if(getTypeAsInt() == 0) {
				triggered = false;

			}
		}else if(Main.addCollisonBox(c.getX() + c.getHeight() + 1, c.getY(), c.getWidth() + 1, c.getHeight() + 1, x,
				y + height - 9, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}
		}else{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}
		}

	}

	public void addListener(Character c, PhysicsObject o, int t, Input i){
		type = t;
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y, 10,
				height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
					triggered = false;
				}else{
					triggered = true;
				}

			}

		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10))

		{
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 9, y, 10, height))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y + height - 9, width,
				10))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX() + c.getHeight() + 1, c.getY(), c.getWidth() + 1, c.getHeight() + 1, x,
				y + height - 9, width, 10))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, Object.ACTION_KEY) || i.isControlPressed(Object.ACTION_BUTTON)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}

		}else if(Main.addCollisonBox(o.getX() + o.getWidth() + 1, o.getY(), o.getWidth() + 1, o.getHeight() + 1, x, y,
				10, height))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}

		}else if(Main.addCollisonBox(o.getX() + o.getWidth() + 1, o.getY() + o.getHeight() + 1, o.getWidth() + 1,
				o.getHeight() + 1, x, y, width, 10))

		{
			if(getTypeAsInt() == 0) {
				triggered = true;

			}
		}else if(Main.addCollisonBox(o.getX(), o.getY() + o.getHeight() + 1, o.getWidth() + 1, o.getHeight() + 1, x, y,
				width, 10))

		{
			if(getTypeAsInt() == 0) {
				triggered = true;

			}
		}else if(Main.addCollisonBox(o.getX(), o.getY(), o.getWidth(), o.getHeight(), x + width - 9, y, 10, height))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;

			}
		}else if(Main.addCollisonBox(o.getX(), o.getY(), o.getWidth() + 1, o.getHeight() + 1, x, y + height - 9, width,
				10))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;

			}
		}else if(Main.addCollisonBox(o.getX() + o.getHeight() + 1, o.getY(), o.getWidth() + 1, o.getHeight() + 1, x,
				y + height - 9, width, 10))

		{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}
		}else

		{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}
		}

	}

	public void setPos(float _x, float _y){
		x = _x;
		y = _y;
	}

	public String getTypeAsString(){

		switch(type){
		case 0:
			return "PRESURE";
		case 1:
			return "ACTION";
		default:
			return "UNDEFINED";

		}
	}

	public int getTypeAsInt(){
		return type;
	}

	public boolean isTriggered(){
		if(triggered) {
			return true;
		}else{
			return false;
		}
	}

}
