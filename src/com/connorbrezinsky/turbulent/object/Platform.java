package com.connorbrezinsky.turbulent.object;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.PhysicsObject;

public class Platform extends Object {



	
	public int type = Object.NORMAL;
	public int nextLvl;
	
	public Platform(float _x, float _y, float w, float h, Color c) {
		super(_x, _y, w, h, c);
		x=_x;
		y=_y;
		width=w;
		height=h;
		color=c;
	}

	public Platform(float _x, float _y, float w, float h, Image[] i, int[] d) {
		super(_x, _y, w, h, i, d);
		x=_x;
		y=_y;
		width=w;
		height=h;
	}
	
	public Platform(float _x, float _y, float w, float h) {
		super(_x, _y, w, h);
		x=_x;
		y=_y;
		width=w;
		height=h;
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



	public boolean isFinished(Character c){
		if(getType() == Object.FINISH) {
			if(Main.leftBoxCollider(c, this)) {
				return true;
			}else if(Main.topBoxCollider(c, this)) {
				return true;
			}else if(Main.rightBoxCollider(c, this)) {
				return true;
			}else if(Main.bottomBoxCollider(c, this)) {
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

	public void setType(int _type){
		type = _type;
	}
	
	public int getType(){
		return type;
	}

	
	

}
