package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Switch {

	public float x, y, width, height;
	public int type;
	public Color color;
	public int actionButton = Input.KEY_E;
	public boolean triggered = false;

	public static int PRESSURE = 0;
	public static int ACTION = 1;

	public Switch(int _x, int _y, int _w, int _h, Color c) {
		x = _x;
		y = _y;
		width = _w;
		height = _h;
		color = c;
	}

	public void render(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void addCollider(Character c){

		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			// left
			c.x = x - c.getWidth();
		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			// top
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			// top
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10, height)) {
			// right
			c.x = x + width;
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width, 10)) {
			// bottom
			c.y = y + height;

		}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
				y + height - 10, width, 10)) {
			// bottom
			c.y = y + height;
		}else{

		}
	}

	public void init(Character c, int t, Input i){
		type = t;
		if(Main.addCollisonBox(c.getX() + c.getWidth() + 1, c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y, 10,
				height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX() + c.getWidth() + 1, c.getY() + c.getHeight() + 1, c.getWidth() + 1,
				c.getHeight() + 1, x, y, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}

			}
		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight() + 1, c.getWidth() + 1, c.getHeight() + 1, x, y,
				width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 9, y, 10, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y + height - 9, width,
				10)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX() + c.getHeight() + 1, c.getY(), c.getWidth() + 1, c.getHeight() + 1, x,
				y + height - 9, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else{
			if(getTypeAsInt() == 0) {
				triggered = false;
			}
		}
	}

	public float getX(){
		return x;
	}

	public float getY(){
		return y;
	}

	public float getWidth(){
		return width;
	}

	public float getHeight(){
		return height;
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

	public void setActionButton(int key){
		this.actionButton = key;
	}

	public void setColor(Color c){
		color = c;
	}

	public void destroy(){
		x = -100;
		y = x;
		color = Color.transparent;
	}

}
