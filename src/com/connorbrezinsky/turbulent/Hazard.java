package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Hazard {

	public float x, y, width, height;
	public Color color;
	public int type;
	Animation obj;
	Image sprite;
	boolean isAnimated = false;
	boolean hasSprite = false;
	boolean col = false;
	
	public Hazard(float _x, float _y, float w, float h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
		isAnimated = false;

	}

	public Hazard(float _x, float _y, float w, float h, Animation a, Image[] img, int[] d) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		obj = a;
		isAnimated = true;
		obj = new Animation(img, d, true);

	}
	
	public Hazard(float _x, float _y, Image img) {
		x = _x;
		y = _y;
		sprite = img;
		width = sprite.getWidth();
		height = sprite.getHeight();
	} 
	
	public Hazard(float _x, float _y, int w, float h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		hasSprite=true;
	}
	
	public Hazard(float _x, float _y, float colw, float colh) {
		x = _x;
		y = _y;
		width = colw;
		height = colh;
		hasSprite = true;
		col = true;
	}
	
	public void addSprite(Image img){
		sprite=img;
	}
	
	public void render(Graphics g){
		if(isAnimated){
			if(obj!=null){
				obj.draw(x,y,width,height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else if(hasSprite){
			
		if(sprite!=null){
			if(!col){
			sprite.draw(x,y,width,height);
			}else{
				sprite.draw(x,y,20,20);
			}
		}else{
			g.setColor(Color.magenta);
			g.drawString("null", x, y);
		}
		
		}else{
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}

	public void addCollider(Character c){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			c.x = x - c.getWidth();
			c.kill();

		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
			c.kill();
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
			c.kill();

		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10, height)) {
			c.x = x + width;
			c.kill();
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width, 10)) {
			c.y = y + height;
		}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
				y + height - 10, width, 10)) {
			c.y = y + height;
		}else{

		}
	}

}
