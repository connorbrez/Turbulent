package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class Platform {

	protected float x, y, width, height;
	protected Color c;
	public int type = 0;
	public int nextLvl;
	boolean isAnimated = false;
	boolean hasSprite = false;
	Image sprite;
	Animation obj;

	public static int NORMAL = 0;
	public static int MOVING = 1;
	public static int FINISH = 2;

	
	public Platform(float _x, float _y, float w, float h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		c = Color.gray;
		type = NORMAL;
		nextLvl = 1337;
	}
	
	public Platform(float _x, float _y, float w, float h, Color _c, int _type) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		c = _c;
		type = _type;
		nextLvl = 1337;
		isAnimated = false;

	}

	public Platform(float _x, float _y, float w, float h, int _type, Image img) {
		sprite = img;
		x = _x;
		y = _y;
		width = w;
		height = h;
		type = _type;
		nextLvl = 1337;
		hasSprite = true;

	}

	public Platform(float _x, float _y, float w, float h, Image img) {
		hasSprite = true;
		sprite = img;
		x = _x;
		y = _y;
		width = w;
		height = h;
		type = NORMAL;
		nextLvl = 1337;
		

	}

	public Platform(float _x, float _y, float w, float h, Color _c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		c = _c;
		type = NORMAL;
		nextLvl = 1337;
		isAnimated = false;

	}

	public Platform(float _x, float _y, float w, float h, int _type, Animation a, Image[] img, int[] d) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		type = _type;
		obj = a;
		nextLvl = 1337;
		isAnimated = true;
		obj = new Animation(img, d, true);

	}
	
	

	public void render(Graphics g){
		if(hasSprite) {
			if(sprite != null) {
				sprite.draw(x, y, width, height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else if(isAnimated) {
			if(obj != null) {
				obj.draw(x, y, width, height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else{
			g.setColor(c);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void addImage(Image img){
		this.hasSprite=true;
		this.sprite=img;
	}
	
	public void addAnimation(Animation a, Image[] img, int[] d){
		this.isAnimated=true;
		obj=a;
		obj = new Animation(img, d, true);
	}

	/*
	 * }else if( c.x < x && c.x + width> x+width && c.y+height>y &&
	 * c.y+height<y+height){
	 * 
	 * }else if( c.x < x && c.x + width> x+width && c.y<y+height &&
	 * c.y>y+height){
	 * 
	 * 
	 */

	public void addCollider(Character c){
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			c.x = x - c.getWidth() - 0.1F;
			if(height<=5){
				c.y=y;
			}

		}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
			c.x = x - c.getWidth() - 0.1F;
			if(height<=5){
				c.y=y;
			}

		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;

		}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;

		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10, height)) {
			c.x = x + width + 0.1F;
			if(height<=5){
				c.y=y;
			}

		}else if(c.x > x && c.x < x + 10 && c.y < y && c.y + c.height > y + height) {
			c.x = x + width + 0.1F;
			if(height<=5){
				c.y=y;
			}
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
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			c.x = x - c.getWidth() - 0.1F;

		}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
			c.x = x - c.getWidth() - 0.1F;

		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;

		}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;

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
		c = Color.transparent;
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

	public String getTypeAsString(){
		switch(type){
		case 0:
			return "NORMAL";
		case 1:
			return "MOVING";
		case 2:
			return "FINISH";
		default:
			return "NORMAL";

		}
	}

	public int getType(){
		return type;
	}

	public void setColor(Color color){
		c = color;
	}

	public void setType(int _type){
		type = _type;
	}

	public void setStart(int x, int y){
		if(getType() == 1) {

		}
	}

	public void setEnd(int x, int y){
		if(getType() == 1) {

		}
	}

	public boolean isFinished(Character c){
		if(getType() == 2) {
			if(Main.addCollisonBox(c.getX() + c.getWidth() + 1, c.getY(), c.getWidth(), c.getHeight() + 1, x, y, 10,
					height)) {
				return true;
			}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(),
					x, y, width, 10)) {
				return true;
			}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
					10)) {
				return true;
			}else if(Main.addCollisonBox(c.getX() - 1, c.getY(), c.getWidth(), c.getHeight(), x + width - 9, y, 10,
					height)) {
				return true;
			}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width,
					10)) {
				return true;
			}else if(Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
					y + height - 10, width, 10)) {
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public void setNextLevel(int level){
		nextLvl = level;
	}

	public void goToNextLevel(StateBasedGame arg0){
		if(nextLvl != 1337) {
			arg0.enterState(nextLvl);
		}else{
			arg0.enterState(arg0.getCurrentStateID() + 1);
		}
	}

}
