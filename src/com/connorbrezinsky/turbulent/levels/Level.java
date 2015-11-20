package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Platform;
import com.connorbrezinsky.turbulent.objectSpawner;
import com.connorbrezinsky.turbulent.Character;


public class Level {

	public static Platform wallLeft = new Platform(0, 0, 20, 600, Color.lightGray, Platform.NORMAL);
	public static Platform wallRight = new Platform(800 - 20, 0, 20, 600, Color.lightGray, Platform.NORMAL);

	public static Platform levelFinish;
	public static objectSpawner objSpawner;

	static Animation aLevelFinish;
	static int d = 100;
	static int[] duration = {d,d,d,d,d,d,d,d,d,d,d,d};
	
	static Animation aObjectSpawner;
	static int d_ = 100;
	static int[] objSDuration = {d_,d_,d_,d_,d_,d_};

	
	public static int[] stage = { 0, 1, 2, 3, 4, 5};
	public static int testChamber = 1926;

	public static void renderBasicWalls(Graphics g){
		wallLeft.render(g);
		wallRight.render(g);
	}
	
	public static void renderLevelFinish(){
		
	}
	
	

	public static void addWallCollison(Character p){
		wallLeft.addCollider(p);
		wallRight.addCollider(p);
	}

	public static void goToLevel(Input i, StateBasedGame arg1){
		if(i.isKeyPressed(Input.KEY_1)) {
			arg1.enterState(stage[1]);
		}else if(i.isKeyPressed(Input.KEY_2)) {
			arg1.enterState(stage[2]);
		}else if(i.isKeyPressed(Input.KEY_3)) {
			arg1.enterState(stage[3]);
		}else if(i.isKeyPressed(Input.KEY_4)) {
			arg1.enterState(stage[4]);
		}else if(i.isKeyPressed(Input.KEY_5)) {
			arg1.enterState(stage[5]);
		}else if(i.isKeyPressed(Input.KEY_6)) {
			arg1.enterState(1);
		}else if(i.isKeyPressed(Input.KEY_7)) {
			arg1.enterState(1);
		}else if(i.isKeyPressed(Input.KEY_T)){
			arg1.enterState(1926);
		}

	}

}
