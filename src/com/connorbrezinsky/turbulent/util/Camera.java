package com.connorbrezinsky.turbulent.util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.connorbrezinsky.turbulent.Character;

public class Camera {

	public float x, y;
	public float[] offsetMin = new float[2];
	public float[] offsetMax = new float[2];
	Character p;

	public Camera(Character player) {
		p = player;

	}

	public Camera(Character player, float minX, float minY, float maxX, float maxY) {
		p = player;

		this.setMaxOffset(maxX, maxY);
		this.setMinOffset(minX, minY);
		
	

	}

	public void update(Graphics g, GameContainer container) {

		g.translate(((container.getWidth() / 2) - this.x), ((container.getHeight() / 2) - this.y));

		x = p.getX();
		y = p.getY();

		

		if (this.x - container.getWidth() / 2 < offsetMin[0]) {
			x = offsetMin[0] + container.getWidth()/2;
		}else if(this.x + container.getWidth()/2 > offsetMax[0]){
			x = offsetMax[0] - container.getWidth()/2;
		}

		if (this.y - container.getHeight() / 2 < offsetMin[1]) {
			y = offsetMin[1] + container.getHeight() / 2;
		}else if(this.y + container.getHeight()> offsetMax[1]){
			y = offsetMax[1] - container.getHeight() / 2;
		}
		
	}

	public void setMinXOffset(float x) {
		offsetMin[0] = x;
	}

	public void setMinYOffset(float y) {
		offsetMin[1] = y;
	}

	public void setMinOffset(float x, float y) {
		this.setMinXOffset(x);
		this.setMinYOffset(y);
	}

	public void setMaxXOffset(float x) {
		offsetMax[0] = x;
	}

	public void setMaxYOffset(float y) {
		offsetMax[1] = y;
	}

	public void setMaxOffset(float x, float y) {
		this.setMaxXOffset(x);
		this.setMaxYOffset(y);
	}
}
