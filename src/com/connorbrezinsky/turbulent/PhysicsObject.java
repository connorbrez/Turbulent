package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class PhysicsObject {

	float x, y, width, height, spawnerX, spawnerY;
	float yVel = 0;
	float xVel = 0;
	float gravity = 0.5F;
	Color color;
	boolean canPickup = true;
	boolean hasSpawner = false;
	boolean goneFromSpawner = true;
	int actionKey = Input.KEY_E;
	Character char_;

	public PhysicsObject(float _x, float _y, float w, float h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}

	public PhysicsObject(float _x, float _y, float w, float h, Color c, boolean spawner) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
		hasSpawner = true;
		goneFromSpawner = false;
	}

	public void addPlayer(Character c){
		char_ = c;
	}

	public void addPlayerCollider(Character c){
		if(goneFromSpawner && canPickup) {
			if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
				c.x = x - c.getWidth() - 0.1F;

			}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
				c.x = x - c.getWidth() - 0.1F;

			}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(),
					x, y, width, 10)) {
				c.y = y - c.getHeight();
				c.yVel = 0;
				c.isJumping = false;
			}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
					10)) {
				c.y = y - c.getHeight();
				c.yVel = 0;
				c.isJumping = false;

			}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
				c.y = y - c.getHeight();
				c.yVel = 0;
				c.isJumping = false;

			}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10,
					height)) {
				c.x = x + width + 0.1F;

			}else if(c.x > x && c.x < x + 10 && c.y < y && c.y + c.height > y + height) {
				c.x = x + width + 0.1F;
			}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width,
					10)) {
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
	}

	public void addPhysObjCollider(PhysicsObject c){
		if(canPickup && c.canPickup && goneFromSpawner) {
			if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
				c.x = x - c.getWidth() - 0.1F;

			}else if(c.x + c.width > x && c.x + c.width < x + 10 && c.y < y && c.y + c.height > y + height) {
				c.x = x - c.getWidth() - 0.1F;

			}else if(Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(),
					x, y, width, 10)) {
				c.y = y - c.getHeight();
				c.yVel = 0;
			}else if(Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
					10)) {
				c.y = y - c.getHeight();
				c.yVel = 0;

			}else if(c.x < x && c.x + c.width > x && c.y + c.height > y && c.y + c.height < y + 10) {
				c.y = y - c.getHeight();
				c.yVel = 0;

			}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10,
					height)) {
				c.x = x + width + 0.1F;

			}else if(c.x > x && c.x < x + 10 && c.y < y && c.y + c.height > y + height) {
				c.x = x + width + 0.1F;
			}else if(Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width,
					10)) {
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
	}

	public void render(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.blue);
		g.fillRect(x, y + (height / 2), width, height / 2);
		if(!canPickup) {
			g.setColor(Color.red);
			g.drawRect(x, y, width, height);
		}
	}

	public void render(Graphics g, ObjectSpawner pObj){

		pObj.render(spawnerX, spawnerY);

		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.blue);
		g.fillRect(x, y + (height / 2), width, height / 2);
		if(!canPickup) {
			g.setColor(Color.red);
			g.drawRect(x, y, width, height);
		}
	}

	public void addPhysics(){
		if(canPickup && goneFromSpawner) {
			yVel += gravity;
			y += yVel;

			if(yVel > 150) {
				yVel = 150;
			}
			if(y > Main.viewportHeight - height) {
				y = Main.viewportHeight - height;
				yVel = 0;

			}
		}

	}

	public void carry(Character c){
		if(char_ != null && char_.direction == Character.LEFT) {
			this.x = c.x + c.width + 10;
			this.y = c.y;
		}else if(char_ != null && char_.direction == Character.RIGHT) {
			this.x = c.x - c.width - 8.1F;
			this.y = c.y;
		}else{
			this.x = c.x + c.width + 10;
			this.y = c.y;
		}
	}

	public void pickup(Character c){
		canPickup = false;
		goneFromSpawner = true;
		this.x = c.x + c.width + 4;
		this.y = c.y;

	}

	public float getWidth(){
		return width;
	}

	public float getHeight(){
		return height;
	}

	public float getX(){
		return x;
	}

	public float getY(){
		return y;
	}

	public float[] getPos(){
		float[] pos = { x, y };
		return pos;
	}

	public void setPos(float _x, float _y){
		x = _x;
		y = _y;
	}

	public void setSpawnerPos(float sx, float sy){
		spawnerX = sx;
		spawnerY = sy;
	}

	public void setSpawnerX(float sx){
		spawnerX = sx;

	}

	public void setSpawnerY(float sy){
		spawnerY = sy;
	}

	public void init(Input i, Character c){
		Trigger trig = new Trigger(x - 5, y - 5, width + 5, height + 5, Trigger.AREA);

		trig.addCollider(c);

		if(trig.isTriggered) {
			if(Main.getKeyPress(i, actionKey) || i.isControlPressed(17)) {
				pickup(c);
			}
		}else if(!canPickup) {
			carry(c);
			if(Main.getKeyPress(i, actionKey) || i.isControlPressed(17)) {
				canPickup = true;
			}
		}
	}

}
