package com.connorbrezinsky.turbulent.object;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Main;

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
