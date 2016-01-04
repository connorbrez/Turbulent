package com.connorbrezinsky.turbulent.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Texture {

	static SpriteLoader sLoader;
	
	public static Image background;
	public static Image bPlay;
	public static Image bExit;
	public static Image loading;
	public static Image move;
	public static Image space_key;
	public static Image spike;
	public static Image pickup;
	public static Image downarrow;
	public static Image blockMagenta;
	public static Image blockBlue;
	public static Image blockLightBlue;
	public static Image blockOrange;
	public static Image e_key;
	public static Image switchWhite_off;
	public static Image switchWhite_on;
	public static Image switchBlack_off;
	public static Image switchBlack_on;
	public static Image dropjump_white;
	public static Image dropjump_black1;
	public static Image dropjump_black2;
	public static Image turbulenceControlls_img;
	public static SpriteLoader turbulenceControlls;
	public static Image turbZ;
	public static Image turbX;
	public static Image turbC;
	

	public static void init() throws SlickException{
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"),20,20));
		turbulenceControlls = new SpriteLoader(new SpriteSheet(new Image("res/turbulence_controlls_2.png"),23,25));

		background = new Image("res/menu-background.png");
		bPlay = new Image("res/button-play.png");
		bExit = new Image("res/button-exit.png");
		loading = new Image("res/loading.png");
		move = new Image("res/move.png");
		space_key = new Image("res/space.png");
		downarrow = new Image("res/downarrow.png");
		pickup = new Image("res/pickup.png");
		e_key = new Image("res/e.png");
		dropjump_white = new Image("res/dropjump_4.png");
		dropjump_black1 = new Image("res/dropjump_1.png");
		dropjump_black2 = new Image("res/dropjump_2.png");
		turbulenceControlls_img = new Image("res/turbulence_controlls_1.png");
		
		blockMagenta = sLoader.getImage(0);
		switchWhite_off = sLoader.getImage(2);
		switchWhite_on = sLoader.getImage(3);
		switchBlack_off = sLoader.getImage(4);
		switchBlack_on = sLoader.getImage(5);
		blockBlue = sLoader.getImage(6);
		spike = sLoader.getImage(7);
		blockOrange = sLoader.getImage(8);
		blockLightBlue = sLoader.getImage(11);
		
		turbZ = turbulenceControlls.getImage(0);
		turbX = turbulenceControlls.getImage(1);
		turbC = turbulenceControlls.getImage(2);
		
		
		
		System.out.println("Textures Initialzed");
		
	}
	
	public static Image[] loadLevelFinish() throws SlickException{
		Image[] iLevelFinish = { new Image("res/animation/finish/phase1.png"),
				new Image("res/animation/finish/phase2.png"), new Image("res/animation/finish/phase3.png"),
				new Image("res/animation/finish/phase4.png"), new Image("res/animation/finish/phase5.png"),
				new Image("res/animation/finish/phase6.png"), new Image("res/animation/finish/phase7.png"),
				new Image("res/animation/finish/phase8.png"), new Image("res/animation/finish/phase9.png"),
				new Image("res/animation/finish/phase10.png"), new Image("res/animation/finish/phase11.png"),
				new Image("res/animation/finish/phase12.png") };
		return iLevelFinish;
	}
	
	public static Image[] loadPhysicsSpawner() throws SlickException{
		Image[] iPhysSpawner = { new Image("res/animation/physSpawner/physSpawner1.png"),
				new Image("res/animation/physSpawner/physSpawner2.png"),
				new Image("res/animation/physSpawner/physSpawner3.png"),
				new Image("res/animation/physSpawner/physSpawner4.png"),
				new Image("res/animation/physSpawner/physSpawner5.png"),
				new Image("res/animation/physSpawner/physSpawner6.png"), };
		return iPhysSpawner;
	}

}
