package com.connorbrezinsky.turbulent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class ObjectSpawner {

	float x, y, width, height;
	Animation obj;
	Image sprite;
	PhysicsObject physObj;
	boolean hasPhysObj = true;

	public ObjectSpawner(Animation a, Image[] img, int[] d) {

		
		width = 30;
		height = 50;
		obj = a;
		obj = new Animation(img, d, true);

	}

	public void render(float x , float y){
		obj.draw(x, y);
	}
	
	

}
