package com.connorbrezinsky.turbulent.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Texture {

	public static Image background;
	public static Image test_background;
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
	public static Image turbZ;
	public static Image turbX;
	public static Image turbC;
	public static Image testPlayer;
	public static Image playerTrail;

	static SpriteLoader turbulenceControlls;
	static SpriteLoader spinningCube;
	static SpriteLoader sLoader;
	static SpriteLoader door;
	static SpriteLoader spawner;
	static SpriteLoader dropjump;
	static SpriteLoader backgrounds;

	public static void init() throws SlickException {
		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"), 20, 20));
		turbulenceControlls = new SpriteLoader(new SpriteSheet(new Image("res/turbulence_controlls_2.png"), 23, 25));
		spinningCube = new SpriteLoader(new SpriteSheet(new Image("res/animation/test.png"), 20, 20));
		door = new SpriteLoader(new SpriteSheet(new Image("res/animation/finish/door_alt.png"), 20, 60));
		spawner = new SpriteLoader(new SpriteSheet(new Image("res/animation/spawner/spawner.png"), 30, 50));
		dropjump = new SpriteLoader(new SpriteSheet(new Image("res/dropjump.png"),49,34));
		backgrounds = new SpriteLoader(new SpriteSheet(new Image("res/backgrounds.png"),800,600));
		
		
		bPlay = new Image("res/button-play.png");
		bExit = new Image("res/button-exit.png");
		move = new Image("res/move.png");
		space_key = new Image("res/space.png");
		downarrow = new Image("res/downarrow.png");
		pickup = new Image("res/pickup.png");
		e_key = new Image("res/e.png");
		turbulenceControlls_img = new Image("res/turbulence_controlls_1.png");

		background = backgrounds.getImage(0);
		loading = backgrounds.getImage(1);
		test_background = backgrounds.getImage(2);
		
		dropjump_black1 = dropjump.getImage(0);
		dropjump_black2 = dropjump.getImage(1);
		dropjump_white = dropjump.getImage(2);
		
		blockMagenta = sLoader.getImage(0);
		testPlayer = sLoader.getImage(1);
		switchWhite_off = sLoader.getImage(2);
		switchWhite_on = sLoader.getImage(3);
		switchBlack_off = sLoader.getImage(4);
		switchBlack_on = sLoader.getImage(5);
		blockBlue = sLoader.getImage(6);
		spike = sLoader.getImage(7);
		blockOrange = sLoader.getImage(8);
		blockLightBlue = sLoader.getImage(11);
		playerTrail = sLoader.getImage(12);

		turbZ = turbulenceControlls.getImage(0);
		turbX = turbulenceControlls.getImage(1);
		turbC = turbulenceControlls.getImage(2);

		System.out.println("Textures Initialzed");

	}

	public static Image[] loadTest() throws SlickException {

		Image[] testAnimation = { spinningCube.getImage(0), spinningCube.getImage(1), spinningCube.getImage(2),
				spinningCube.getImage(3), spinningCube.getImage(4), spinningCube.getImage(5),
				spinningCube.getImage(6) };
		return testAnimation;
	}

	public static Image[] loadLevelFinish() throws SlickException {
		Image[] iLevelFinish = { door.getImage(0), door.getImage(1), door.getImage(2), door.getImage(3),
				door.getImage(4), door.getImage(5), door.getImage(6), door.getImage(7), door.getImage(8),
				door.getImage(9), door.getImage(10), door.getImage(11) };

		return iLevelFinish;
	}

	public static Image[] loadPhysicsSpawner() throws SlickException {
		Image[] iPhysSpawner = { spawner.getImage(0), spawner.getImage(1), spawner.getImage(2), spawner.getImage(3),
				spawner.getImage(4), spawner.getImage(5) };

		return iPhysSpawner;
	}

}
