package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

import com.connorbrezinsky.turbulent.object.PhysicsObject;

public class ObjectSpawner {

	float x, y, width, height;
	Animation obj;
	PhysicsObject physObj;
	boolean hasPhysObj = true;

	public ObjectSpawner(Image[] img, int[] d) {
		width = 30;
		height = 50;
		obj = new Animation(img, d, true);
	}

	public void render(float x , float y){
		obj.draw(x, y);
	}
	
	

}
