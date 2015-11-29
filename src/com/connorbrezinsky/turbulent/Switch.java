package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Switch {

	public float x, y, width, height;
	public int type;
	public Color color;
	public int actionButton = Input.KEY_E;
	public int actionButtonController = 17;
	public boolean triggered = false;
	boolean isAnimated = false;
	Animation obj;
	boolean hasSprite = false;
	Image sprite;

	public static int PRESSURE = 0;
	public static int ACTION = 1;

	public Switch(int _x, int _y, int _w, int _h, Color c) {
		x = _x;
		y = _y;
		width = _w;
		height = _h;
		color = c;
	}

	public Switch(float _x, float _y, float w, float h, Animation a, Image[] img, int[] d) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		obj = a;
		isAnimated = true;
		obj = new Animation(img, d, true);

	}

	public Switch(float _x, float _y, float w, float h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		hasSprite = true;
		sprite = null;

	}

	public void addSprite(Image img){
		sprite = img;
	}

	public void changeSprite(Image img){
		sprite = img;
	}

	public void changeSprite(Image img, int _x, int _y){
		sprite = img;
		x = _x;
		y = _y;
	}

	public void changeSprite(Image img, int _x, int _y, int w, int h){
		sprite = img;
		x = _x;
		y = _y;
		width = w;
		height = h;
	}

	public void render(Graphics g){
		if(isAnimated) {
			if(obj != null) {
				obj.draw(x, y, width, height);
			}else{
				g.setColor(Color.magenta);
				g.drawString("null", x, y);
			}
		}else if(hasSprite) {
			if(sprite != null) {
				sprite.draw(x, y, width, height);
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
			if(height <= 5) {
				c.y = y - c.height - 1;
			}else{
				c.x = x - c.getWidth() - 0.1F;

			}

		}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
			if(height <= 5) {
				c.y = y - c.height - 1;
			}else{
				c.x = x - c.getWidth() - 0.1F;

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
			if(height <= 5) {
				c.y = y - c.height - 1;
			}else{
				c.x = x + width + 0.1F;

			}

		}else if(c.x > x && c.x < x + 10 && c.y < y && c.y + c.height > y + height) {
			if(height <= 5) {
				c.y = y - c.height - 1;
			}else{
				c.x = x + width + 0.1F;
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

	public void addCollider(PhysicsObject c){

		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			c.x = x - c.getWidth() - 0.1F;

		}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
			c.x = x - c.getWidth() - 0.1F;

		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;

		}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
			c.y = y - c.getHeight();
			c.yVel = 0;

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

	public void init(Character c, int t, Input i){
		type = t;
		if(Main.addCollisonBox(c.getX() + c.getWidth() + 15, c.getY(), c.getWidth() + 15, c.getHeight() + 15, x, y,
				width, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x,
				y, width, height)) {
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}

			}
		}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
				height)) {
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else
			if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 9, y, width, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth() + 15, c.getHeight() + 15, x, y + height - 9,
				width, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}
		}else if(Main.addCollisonBox(c.getX() + c.getHeight() + 15, c.getY(), c.getWidth() + 15, c.getHeight() + 5, x,
				y + height - 9, width, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
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

	public void init(PhysicsObject c, int t, Input i){
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

	public void init(Character c, PhysicsObject o, int t, Input i){
		type = t;
		if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth() + 1, c.getHeight() + 1, x, y, 10,
				height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
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
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}

			}
		}else
			if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;
			}else if(getTypeAsInt() == 1) {
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
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
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
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
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
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
				if(Main.getKeyPress(i, actionButton) || i.isControlPressed(17)) {
					if(triggered) {
						triggered = false;
					}else{
						triggered = true;
					}
				}
			}

		}else if(Main.addCollisonBox(o.getX() + o.getWidth() + 1, o.getY(), o.getWidth() + 1, o.getHeight() + 1, x, y,
				10, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;
			}

		}else if(Main.addCollisonBox(o.getX() + o.getWidth() + 1, o.getY() + o.getHeight() + 1, o.getWidth() + 1,
				o.getHeight() + 1, x, y, width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;

			}
		}else if(Main.addCollisonBox(o.getX(), o.getY() + o.getHeight() + 1, o.getWidth() + 1, o.getHeight() + 1, x, y,
				width, 10)) {
			if(getTypeAsInt() == 0) {
				triggered = true;

			}
		}else if(Main.addCollisonBox(o.getX(), o.getY(), o.getWidth(), o.getHeight(), x + width - 9, y, 10, height)) {
			if(getTypeAsInt() == 0) {
				triggered = false;

			}
		}else if(Main.addCollisonBox(o.getX(), o.getY(), o.getWidth() + 1, o.getHeight() + 1, x, y + height - 9, width,
				10)) {
			if(getTypeAsInt() == 0) {
				triggered = false;

			}
		}else if(Main.addCollisonBox(o.getX() + o.getHeight() + 1, o.getY(), o.getWidth() + 1, o.getHeight() + 1, x,
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
