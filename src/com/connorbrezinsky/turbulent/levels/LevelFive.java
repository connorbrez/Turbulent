package com.connorbrezinsky.turbulent.levels;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.connorbrezinsky.turbulent.Character;
import com.connorbrezinsky.turbulent.Hazard;
import com.connorbrezinsky.turbulent.Main;
import com.connorbrezinsky.turbulent.SpriteLoader;
import com.connorbrezinsky.turbulent.State;
import com.connorbrezinsky.turbulent.object.Door;
import com.connorbrezinsky.turbulent.object.Object;
import com.connorbrezinsky.turbulent.object.Platform;
import com.connorbrezinsky.turbulent.object.Switch;

public class LevelFive extends BasicGameState {

	State levelFive = new State(this);
	
	Color bg = Color.black;
	Image e_key;
	Image dropjump_white;
	Image dropjump_black1;
	Image dropjump_black2;

	Color objColor = Color.green;

	public Character player = new Character(40, Main.getMidY(20) + 100, 20, 20, Color.darkGray);

	SpriteLoader sLoader;

	public Door finishDoor = new Door(650, 600 - 100, 10, 100, Color.green);
	public Door door0 = new Door(650, 205, 10, 50, Color.red);

	public Platform obj1 = new Platform(Main.getMidX(50), 520, 50, 10, Color.green);

	public Platform obj2 = new Platform(260, 480, 30, 10, Color.white);
	public Platform obj3 = new Platform(320, 400, 30, 10, Color.white);
	public Platform obj4 = new Platform(350, 350, 30, 10, Color.white);
	public Platform obj5 = new Platform(420, 280, 100, 10, Color.white);

	public Platform obj6 = new Platform(420, 480, 30, 10, Color.black);
	public Platform obj7 = new Platform(480, 420, 30, 10, Color.black);
	public Platform obj8 = new Platform(430, 370, 30, 10, Color.black);
	public Platform obj9 = new Platform(360, 310, 30, 10, Color.black);
	public Platform obj10 = new Platform(230, 250, 100, 10, Color.black);
	public Platform obj11 = new Platform(150, 250, 20, 10, Color.black);
	public Platform obj12 = new Platform(100, 250, 20, 10, Color.black);
	public Platform obj13 = new Platform(50, 250, 20, 10, Color.black);
	public Platform obj14 = new Platform(0, 200, 20, 10, Color.black);
	public Platform obj15 = new Platform(80, 140, 400, 10, Color.black);

	public Platform obj0 = new Platform(800 - 200, 600 - 345, 200, 275, Color.white);
	public Platform obj00 = new Platform(800 - 200, 0, 200, 205, Color.black);
	public Platform obj000 = new Platform(0, 0, 800, 20, Color.black);

	public Hazard spike1 = new Hazard(210, 140 - 20, 20F, 13);
	public Hazard spike2 = new Hazard(280, 140 - 20, 20F, 13);

	public Switch doorSwitch0 = new Switch(480, 280 - 30, 20, 20);
	public Switch doorSwitch1 = new Switch(750, 600 - 345 - 30, 20, 20);

	public Switch sDoor0 = new Switch(260, 250 - 30, 20, 20);

	public Switch colorSwitch = new Switch(10, 600 - 30, 20, 20);

	public LevelFive(int s) {

	}

	

	@Override
	public int getID(){
		return levelFive.getId();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		player.setSpawn(100, 550);
		
		
		Image[] iLevelFinish = { new Image("res/animation/finish/phase1.png"),
				new Image("res/animation/finish/phase2.png"), new Image("res/animation/finish/phase3.png"),
				new Image("res/animation/finish/phase4.png"), new Image("res/animation/finish/phase5.png"),
				new Image("res/animation/finish/phase6.png"), new Image("res/animation/finish/phase7.png"),
				new Image("res/animation/finish/phase8.png"), new Image("res/animation/finish/phase9.png"),
				new Image("res/animation/finish/phase10.png"), new Image("res/animation/finish/phase11.png"),
				new Image("res/animation/finish/phase12.png") };

		dropjump_white = new Image("res/dropjump_4.png");
		dropjump_black1 = new Image("res/dropjump_1.png");
		dropjump_black2 = new Image("res/dropjump_2.png");

		Level.levelFinish = new Platform(700, 600 - 60, 20, 60, iLevelFinish, Level.duration);
		Level.levelFinish.setType(Object.FINISH);

		sLoader = new SpriteLoader(new SpriteSheet(new Image("res/sprites.png"), 20, 20));

		doorSwitch0.addSprite(sLoader.getImage(2));
		doorSwitch1.addSprite(sLoader.getImage(4));
		
		sDoor0.addSprite(sLoader.getImage(4));
		colorSwitch.addSprite(sLoader.getImage(3));

		spike1.addSprite(sLoader.getImage(7));
		spike2.addSprite(sLoader.getImage(7));

		this.colorSwitch.setCustomActionRadius(25, 25, 55, 55);

	}

	

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException{
		g.setBackground(bg);

		finishDoor.render(g);
		colorSwitch.render(g);
		Level.levelFinish.render(g);

		obj0.render(g);
		obj00.render(g);
		obj000.render(g);

		obj1.render(g);
		obj2.render(g);
		obj3.render(g);
		obj4.render(g);
		obj5.render(g);
		obj6.render(g);
		obj7.render(g);
		obj8.render(g);
		obj9.render(g);
		obj10.render(g);
		obj11.render(g);
		// obj12.render(g);
		obj13.render(g);
		obj14.render(g);
		obj15.render(g);

		if(colorSwitch.triggered) {
			sDoor0.render(g);
			door0.render(g);
			doorSwitch1.render(g);
			spike1.render(g);
			spike2.render(g);
			dropjump_black2.draw(90, 270);
			dropjump_black1.draw(525, 235);
		}else{
			doorSwitch0.render(g);
			dropjump_white.draw(310, 500);
		}

		player.render(g);

	}

	private void setObjColor(Color c){
		obj1.setColor(c);
		finishDoor.setColor(c);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException{
		Input i = arg0.getInput();
		player.addBasicController(i, Input.KEY_A, Input.KEY_D, Input.KEY_SPACE);
		player.addPhysics();
		player.addWorldCollider();

		colorSwitch.addCollider(player);
		colorSwitch.addListener(player, Switch.ACTION, i);

		Level.levelFinish.addCollider(player);
		Level.levelFinish.setNextLevel(6);
		finishDoor.addCollider(player);

		sDoor0.addListener(player, Switch.ACTION, i);
		sDoor0.addCollider(player);

		obj0.addCollider(player);
		obj00.addCollider(player);
		obj000.addCollider(player);

		obj1.addCollider(player);

		if(colorSwitch.isTriggered()) {
			doorSwitch1.addListener(player, Switch.ACTION, i);
			bg = Color.white;
			colorSwitch.setColor(Color.black);
			setObjColor(Color.orange);
			obj0.setColor(Color.black);

			obj6.addCollider(player);
			obj7.addCollider(player);
			obj8.addCollider(player);
			obj9.addCollider(player);
			obj10.addCollider(player);
			obj11.addCollider(player);
			// obj12.addCollider(player);
			obj13.addCollider(player);
			obj14.addCollider(player);
			obj15.addCollider(player);

			door0.addCollider(player);
			door0.addSwitch(sDoor0);
			doorSwitch1.addCollider(player);

			colorSwitch.changeSprite(sLoader.getImage(5));

			spike1.addCollider(player);
			spike2.addCollider(player);

		}else{
			this.doorSwitch0.addListener(player, Switch.ACTION, i);
			bg = Color.black;
			colorSwitch.setColor(Color.white);
			setObjColor(Color.green);

			obj0.setColor(Color.white);
			colorSwitch.changeSprite(sLoader.getImage(3));
			obj2.addCollider(player);
			obj3.addCollider(player);
			obj4.addCollider(player);
			obj5.addCollider(player);

			this.doorSwitch0.addCollider(player);

		}

		if(doorSwitch0.isTriggered()) {
			doorSwitch0.destroy();
		}

		if(doorSwitch1.isTriggered()) {
			doorSwitch1.destroy();
		}

		if(sDoor0.isTriggered()) {
			sDoor0.destroy();
		}

		if(doorSwitch0.isTriggered() && doorSwitch1.isTriggered()) {
			finishDoor.open();
		}else{
			finishDoor.close();
		}

		if(Level.levelFinish.isFinished(player)) {
			Level.levelFinish.goToNextLevel(arg1);
		}

		Level.goToLevel(i, arg1);
	}

	
}
