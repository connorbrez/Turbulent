package com.connorbrezinsky.turbulent.object;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.PhysicsObject;

public class Object {

	public static int NORMAL = 0;
	public static int FINISH = 1;

	public static int ACTION_KEY = Input.KEY_E;
	public static int ACTION_BUTTON = 17;

	public boolean isAnimated, hasSprite = false;

	public float x;
	public float y;
	public float width;
	public float height;
	protected Color color;
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
		if(hasSprite) {
			if(img != null) {
				img.draw(x, y, width, height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else if(isAnimated) {
			if(a != null) {
				a.draw(x, y, width, height);
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
		img = s;
	}

	public void changeSprite(Image s){
		img = s;
	}

	public void addCollider(Character c){
		
		Rectangle rect = new Rectangle(c.getX(),c.getY(), c.getWidth(), 10);
		Rectangle rect2 = new Rectangle(this.getX(), this.getY(), this.getWidth(),10);
		
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

		}else if(Main.checkCollison(c, this)){
			c.y = y - c.getHeight() - 0;
			c.yVel = 0;
			c.isJumping = false;
		}else if(rect.intersects(rect2)){
			c.y = y - c.getHeight() - 0;
			c.yVel = 0;
			c.isJumping = false;
		}
	}
	
	public void addCollider(PhysicsObject c){

		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			c.x = x - c.getWidth() - 0.1F;

		}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
			c.x = x - c.getWidth() - 0.1F;

		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			c.yVel = 0;
			c.y = y - c.getHeight();
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			c.yVel = 0;
			c.y = y - c.getHeight();
		}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
			c.yVel = 0;
			c.y = y - c.getHeight();
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10, height)) {
			c.x = x + width + 0.1F;
		}else if(c.x > x && c.x < x + 10 && c.y < y && c.y + c.height > y + height) {
			c.x = x + width + 0.1F;
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width, 10)) {
			c.y = y + height;
			c.yVel = 0;
		}else if(c.x < x && c.x + c.width > x && c.y < y + height - 10 && c.y + c.height > y + height - 10) {
			c.y = y + height;
			c.yVel = 0;
		}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
				y + height - 10, width, 10)) {
			c.y = y + height;
			c.yVel = 0;
		}
	}

	
	public void addCollider(Character c, PhysicsObject pObj){
		this.addCollider(c);

		if(pObj.canPickup) {
			if(Main.addCollisonBox(pObj.getX() + pObj.getWidth(), pObj.getY(), pObj.getWidth(), pObj.getHeight(), x, y,
					10, height)) {
				pObj.x = x - pObj.getWidth() - 0.1F;

			}else if(pObj.x + pObj.width > x && pObj.x + pObj.width < x + 10 && pObj.y < y
					&& pObj.y + pObj.height > y + height) {
				pObj.x = x - c.getWidth() - 0.1F;

			}else if(Main.addCollisonBox(pObj.getX() + pObj.getWidth(), pObj.getY() + pObj.getHeight(), pObj.getWidth(),
					pObj.getHeight(), x, y, width, 10)) {
				pObj.y = y - pObj.getHeight();
				pObj.yVel = 0;
			}else if(Main.addCollisonBox(pObj.getX(), pObj.getY() + pObj.getHeight(), pObj.getWidth(), pObj.getHeight(),
					x, y, width, 10)) {
				pObj.y = y - pObj.getHeight();
				pObj.yVel = 0;

			}else
				if(pObj.x < x && pObj.x + pObj.width > x && pObj.y + pObj.height > y && pObj.y + pObj.height < y + 10) {
				pObj.y = y - pObj.getHeight();
				pObj.yVel = 0;

			}else if(Main.addCollisonBox(pObj.getX(), pObj.getY(), pObj.getWidth(), pObj.getHeight(), x + width - 10, y,
					10, height)) {
				pObj.x = x + width + 0.1F;

			}else if(pObj.x > x && pObj.x < x + 10 && pObj.y < y && pObj.y + pObj.height > y + height) {
				pObj.x = x + width + 0.1F;
			}else if(Main.addCollisonBox(pObj.getX(), pObj.getY(), pObj.getWidth(), pObj.getHeight(), x,
					y + height - 10, width, 10)) {
				pObj.y = y + height;
				pObj.yVel = 0;

			}else if(pObj.x < x && pObj.x + pObj.width > x && pObj.y < y + height - 10
					&& pObj.y + pObj.height > y + height - 10) {
				pObj.y = y + height;
				pObj.yVel = 0;

			}else if(Main.addCollisonBox(pObj.getX() + pObj.getHeight(), pObj.getY(), pObj.getWidth(), pObj.getHeight(),
					x, y + height - 10, width, 10)) {
				pObj.y = y + height;
				pObj.yVel = 0;
			}
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
