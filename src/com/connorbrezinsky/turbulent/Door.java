package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Door {

	public int x, y, width, height;
	public Color color;
	public boolean isOpen = false;

	public Door(int _x, int _y, int w, int h, Color c) {
		x = _x;
		y = _y;
		width = 5;
		height = h;
		color = c;
	}

	public void render(Graphics g){
		g.setColor(color);
		if(!isOpen) {
			g.fillRect(x, y, width, height);
		}else{
			// g.fillRect(x, y, width, height);
		}
	}

	public void addCollider(Character c){
		if(!isOpen) {
			if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 3, height)) {
				c.x = x - c.getWidth();
			}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(),
					x, y, width, 3)) {
				c.y = y - c.getHeight();
				c.yVel = 0;
				c.isJumping = false;
			}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
					3)) {
				c.y = y - c.getHeight();
				c.yVel = 0;
				c.isJumping = false;

			}else
				if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 5, y, 3, height)) {
				c.x = x + width;
			}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 3, width,
					3)) {
				c.y = y + height;
			}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
					y + height - 3, width, 10)) {
				c.y = y + height;
			}else{

			}
		}
	}

	public void addSwitch(Switch s){
		if(s.isTriggered()) {
			open();
		}else{
			close();
		}
	}

	public void open(){
		isOpen = true;
	}

	public void close(){
		isOpen = false;
	}

	public String getState(){
		if(isOpen) {
			return "open";
		}else{
			return "closed";
		}
	}

	public void setColor(Color c){
		color = c;
	}

}
