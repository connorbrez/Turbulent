package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Animation;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.object.Platform;

public class Level {



	public static SpriteSheet spriteSheet;
	
	public static Platform levelFinish;
	
	public static SpriteSheet aLoader;
	
	public static Image characterTest;

	static Animation aLevelFinish;
	static int d = 100;
	static int[] duration = { d, d, d, d, d, d, d, d, d, d, d, d };
	static int[] lsDuration = { d, d, d, d, d, d, d, d, d, d, d, d, d, d, d };


	static Animation aObjectSpawner;
	static Animation aLevelSwitch;
	static int d_ = 100;
	static int[] objSDuration = { d_, d_, d_, d_, d_, d_ };

	public static int[] stage = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	public static int testChamber = 1926;

	public static void renderLevelFinish(){
		
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
			arg1.enterState(stage[6]);
		}else if(i.isKeyPressed(Input.KEY_7)) {
			arg1.enterState(stage[7]);
		}else if(i.isKeyPressed(Input.KEY_8)) {
			arg1.enterState(stage[8]);
		}else if(i.isKeyPressed(Input.KEY_9)) {
			arg1.enterState(stage[9]);
		}else if(i.isKeyPressed(Input.KEY_0)) {
			arg1.enterState(stage[10]);
		}else if(i.isKeyPressed(Input.KEY_T)) {
		//	arg1.enterState(1926);
		}

	}

}
