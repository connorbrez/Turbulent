package com.connorbrezinsky.turbulent.object;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;

public class Door extends Object {

	public float x, y, width, height;
	public Color color;
	public boolean isOpen = false;

	public Door(float _x, float _y, float w, float h, Color c) {
		super(_x, _y, w, h, c);
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}
	
	public Door(float _x, float _y, float w, float h, Image[] i, int[] d) {
		super(_x, _y, w, h, i, d);
		x=_x;
		y=_y;
		width=w;
		height=h;
	}
	
	public Door(float _x, float _y, float w, float h) {
		super(_x, _y, w, h);
		x=_x;
		y=_y;
		width=w;
		height=h;
	}

	public void render(Graphics g){
		g.setColor(color);
		if(!isOpen) {
			g.fillRect(x, y, width, height);
		}
	}

	public void addCollider(Character c){
		if(!isOpen) {
			if(Main.leftBoxCollider(c, this)) {
				c.x = x - c.getWidth() - 0F;
				c.moving = false;
				if(height <= 5) {
					c.y = y;
				}
			}else if(Main.topBoxCollider(c, this)) {
				c.y = y - c.getHeight() - 0;
				c.yVel = 0;
				c.isJumping = false;
			}else if(Main.rightBoxCollider(c, this)) {
				c.moving = false;
				c.x = x + width + 0;
				if(height <= 5) {
					c.y = y;
				}

			}else if(Main.bottomBoxCollider(c, this)) {
				c.y = y + height + 0;
				c.yVel = 0;

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


}
