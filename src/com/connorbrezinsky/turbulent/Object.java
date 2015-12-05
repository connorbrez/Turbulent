package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Object {

	public static int NORMAL = 0;
	public static int FINISH = 1;
	
	public static int ACTION_KEY = Input.KEY_E;
	public static int ACTION_BUTTON = 17;
	
	public boolean isAnimated, hasSprite = false;
	
	float x, y, width, height;
	Color color;
	Animation a;
	Image img;
	
	

	public Object(float _x, float _y, float w, float h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}
	
	public Object(float _x, float _y, float w, float h, Image[] i, int[] d) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		a = new Animation(i, d);
		isAnimated = true;
	}
	
	public Object(float _x, float _y, float w, float h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		hasSprite = true;
	}
	
	

	public void render(Graphics g){
		if(hasSprite){
			if(img!=null){
				img.draw(x,y,width,height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else if(isAnimated){
			if(a!=null){
				a.draw(x,y,width,height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else{
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	
	}
	
	public void outline(Graphics g, Color c){
		g.setColor(c);
		g.drawRect(x, y, width, height);
	}
	
	public void addSprite(Image s){
		img=s;
	}
	
	public void changeSprite(Image s){
		img=s;
	}

	public void addCollider(Character c){
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

	public void destroy(){
		x = -100;
		y = x;
		color = Color.transparent;
	}

	public void setColor(Color c){
		color = c;
	}

	
	// HELPER FUNCTIONS
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
	
}
