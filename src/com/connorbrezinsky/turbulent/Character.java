package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.connorbrezinsky.turbulent.levels.Level;

public class Character {

	public float x, y, width, height, yVel, cameraX, cameraY;
	public float gravity = 0.5F;
	public float xSpeed = 3F;
	public float xVel = 0F;
	public float ySpeed = -9.9F;
	public Color color;
	public boolean isJumping = true;
	public int runningTime;
	public boolean canMove = true;
	public Rectangle rPl;
	public String direction = LEFT;
	Image sprite;

	public static String LEFT = "left";
	public static String RIGHT = "right";
	public boolean isTesting = false;
	public boolean moving = false;

	public Character(float _x, float _y, float w, float h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
		rPl = new Rectangle(x, y, width, height);
	}

	public Character(float _x, float _y, float w, float h) {
		x = _x;
		y = _y;
		width = w;
		height = h;

	}

	public Character(float _x, float _y, float w, float h, boolean test) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		isTesting = true;
		rPl = new Rectangle(x, y, width, height);

	}

	public void addSprite(Image s) {
		sprite = s;
	}

	public void render(Graphics g) {

		if (!isTesting) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		} else if (sprite != null) {
			sprite.draw(x, y, width, height);
		} else {
			Level.characterTest.draw(x, y, width, height);
		}

	}

	public void addCollider(Character c) {
		if (Main.addCollisonBox(c.getX() + c.getWidth(), c.getY(), c.getWidth(), c.getHeight(), x, y, 10, height)) {
			c.x = x - c.getWidth();

		} else if (Main.addCollisonBox(c.getX() + c.getWidth(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(),
				x, y, width, 10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;
		} else if (Main.addCollisonBox(c.getX(), c.getY() + c.getHeight(), c.getWidth(), c.getHeight(), x, y, width,
				10)) {
			c.y = y - c.getHeight();
			c.yVel = 0;
			c.isJumping = false;

		} else if (Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x + width - 10, y, 10,
				height)) {
			c.x = x + width;
		} else if (Main.addCollisonBox(c.getX(), c.getY(), c.getWidth(), c.getHeight(), x, y + height - 10, width,
				10)) {
			c.y = y + height;
		} else if (Main.addCollisonBox(c.getX() + c.getHeight(), c.getY(), c.getWidth(), c.getHeight(), x,
				y + height - 10, width, 10)) {
			c.y = y + height;
		}
	}

	public void addWorldCollider() {
		if (x < 0) {
			x = 1;
		} else if (x + width > Main.viewportWidth) {
			x = Main.viewportWidth - 21;
		} else if (y < 0) {
			y = 1;
			this.yVel = 0;
		}
	}

	public void addCamera() {
		cameraX = this.x;
		cameraY = this.y;
	}

	public void addBasicController(Input i, int right, int left, int jump) {

		if (i.isKeyDown(left)) {
			direction = LEFT;
			moving = true;
			if (moving) {
				xVel = xSpeed;
			} else {
				xVel = 0;
			}
			if (i.isKeyPressed(jump)) {
				jump();
			} else if (isJumping) {
				x += xVel / 4 + 1.3F;
			} else {
				x += xVel;
			}
		} else if (i.isKeyDown(right)) {
			moving = true;
			direction = RIGHT;
			if (moving) {
				xVel = xSpeed;
			} else {
				xVel = 0;
			}
			if (i.isKeyPressed(jump)) {
				jump();
			} else if (isJumping) {
				x -= xVel / 4 + 1.3F;
			} else {
				x -= xVel;

			}
		} else if (i.isKeyPressed(jump)) {
			jump();
		} else {
			xVel = 0;
			moving = false;
		}

		try {
			if (i.getControllerCount() > 0) {

				if (i.getAxisValue(0, 0) > 0.5) {
					xVel = xSpeed;
					direction = LEFT;
					if (i.isControlPressed(15, 0)) {
						jump();
					} else if (isJumping) {
						x += xVel / 4 + 1.3F;
					} else {
						x += xVel;
					}
				} else if (i.getAxisValue(0, 0) < -0.5) {
					direction = RIGHT;
					xVel = xSpeed;
					if (i.isControlPressed(15, 0)) {
						jump();
					} else if (isJumping) {
						x -= xVel / 4 + 1.3F;
					} else {
						x -= xVel;
					}
				} else if (i.isControlPressed(15, 0)) {
					jump();
				} else {
					xVel = 0;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void jump() {
		if (isJumping == false) {
			yVel = ySpeed;
			isJumping = true;
			canMove = false;
		}

	}

	float sx, sy = 1000;

	public void setSpawn(float _x, float _y) {
		sx = _x;
		sy = _y;
	}

	public void kill() {
		if (sx >= 1000 & sy >= 1000) {
			setPos(100, 550);
		} else {
			setPos(sx, sy);
		}
	}

	public void addPhysics() {

		yVel += gravity;
		y += yVel;

		if (yVel > 150) {
			yVel = 150;
		}
		if (y > Main.viewportHeight - height) {
			y = Main.viewportHeight - height;
			yVel = 0;
			isJumping = false;

		}

	}

	// HELPER FUNCTIONS
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getYVel() {
		return yVel;
	}

	public float getGravity() {
		return gravity;
	}

	public float getXSpeed() {
		return xSpeed;
	}

	public float getYSpeed() {
		return ySpeed;
	}

	public void setGravity(float g) {
		gravity = g;
	}

	public void setXSpeed(float xS) {
		xSpeed = xS;
	}

	public void setYSpeed(float yS) {
		ySpeed = yS;
	}

	public void setPos(float _x, float _y) {
		x = _x;
		y = _y;
	}

	public void setX(float _x) {
		x = _x;
	}

	public void setY(float _y) {
		y = _y;
	}

	public void setColor(Color c) {
		color = c;
	}

}
